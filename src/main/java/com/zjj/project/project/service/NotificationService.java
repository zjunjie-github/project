package com.zjj.project.project.service;

import com.zjj.project.project.dto.NotificationDTO;
import com.zjj.project.project.dto.PaginationDTO;
import com.zjj.project.project.enums.NotificationStatusEnum;
import com.zjj.project.project.enums.NoyificationTypeEnum;
import com.zjj.project.project.exception.CustomizeErrorCode;
import com.zjj.project.project.exception.CustomizeException;
import com.zjj.project.project.mapper.NotificationMapper;
import com.zjj.project.project.model.Notification;
import com.zjj.project.project.model.NotificationExample;
import com.zjj.project.project.model.User;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author zhangjunjie 2019/8/19
 */

@Service
public class NotificationService {

    @Autowired
    private NotificationMapper notificationMapper;

    public PaginationDTO list(Long userId, Integer page, Integer size) {
        PaginationDTO<NotificationDTO> paginationDTO = new PaginationDTO<>();
        Integer totalPage;
        NotificationExample notificationExample = new NotificationExample();
        notificationExample.createCriteria().andReceiverEqualTo(userId);
        Integer totalCount = (int) notificationMapper.countByExample(notificationExample);
        if (totalCount % size == 0){
            totalPage = totalCount / size;
        }else {
            totalPage = totalCount / size + 1;
        }
        if (page < 1){
            page = 1;
        }
        if (page > totalPage){
            page = totalPage;
        }
        paginationDTO.setPagination(totalPage,page);

        //offset = size * (page - 1)
        Integer offset = size * (page - 1);
        NotificationExample example = new NotificationExample();
        example.createCriteria().andReceiverEqualTo(userId);
        example.setOrderByClause("gmt_create desc");
        List<Notification> notifications = notificationMapper.selectByExampleWithRowbounds(example,new RowBounds(offset,size));
        if (notifications.size() == 0){
            return paginationDTO;
        }
        List<NotificationDTO> notificationDTOS = new ArrayList<>();
        for (Notification notification : notifications){
            NotificationDTO notificationDTO = new NotificationDTO();
            BeanUtils.copyProperties(notification,notificationDTO);
            notificationDTO.setTypeName(NoyificationTypeEnum.nameOfType(notification.getType()));
            notificationDTOS.add(notificationDTO);
        }
        paginationDTO.setData(notificationDTOS);
        return paginationDTO;
    }

    public Long unreadCount(Long userId) {
        NotificationExample notificationExample = new NotificationExample();
        notificationExample.createCriteria().andReceiverEqualTo(userId).andStatusEqualTo(NotificationStatusEnum.UNREAD.getStatus());
        return notificationMapper.countByExample(notificationExample);
    }

    public NotificationDTO read(Long id, User user) {
        Notification notification = notificationMapper.selectByPrimaryKey(id);
        if (notification == null){
            throw new CustomizeException(CustomizeErrorCode.NOTIFICATION_NOT_FOUND);
        }
        if (!Objects.equals(notification.getReceiver(), user.getId())){
            throw new CustomizeException(CustomizeErrorCode.READ_NOTIFICATION_FAIL);
        }
        notification.setStatus(NotificationStatusEnum.READ.getStatus());
        notificationMapper.updateByPrimaryKey(notification);
        NotificationDTO notificationDTO = new NotificationDTO();
        BeanUtils.copyProperties(notification,notificationDTO);
        notificationDTO.setTypeName(NoyificationTypeEnum.nameOfType(notification.getType()));
        return notificationDTO;
    }
}
