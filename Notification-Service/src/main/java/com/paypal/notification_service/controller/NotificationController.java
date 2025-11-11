package com.paypal.notification_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.notification_service.entity.Notification;
import com.paypal.notification_service.service.NotificationService;

@RestController
@RequestMapping("/api/notify")
public class NotificationController {
	
	@Autowired
	private NotificationService notificationService;
	
	@PostMapping
	public Notification sendNotification(@RequestBody Notification notification) {
		return notificationService.sendNotification(notification);
	}
	
	@GetMapping("/{userId}")
	public List<Notification> getNotificationByUser(@PathVariable Long userId){
		return notificationService.getNotificationsByUserId(userId);
	}
}
