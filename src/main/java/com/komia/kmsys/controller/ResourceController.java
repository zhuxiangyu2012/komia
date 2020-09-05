package com.komia.kmsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.komia.common.KomiaAjaxInfo;
import com.komia.kmsys.service.ResourceService;
import com.komia.util.KomiaConstant;


@RestController
@RequestMapping(value= KomiaConstant.COMMON_URL + "/resource")
public class ResourceController {
	@Autowired
	private ResourceService resourceService;
	
	@GetMapping("/resources")
	public ResponseEntity<KomiaAjaxInfo> getResources() {
		return ResponseEntity.ok(KomiaAjaxInfo.success(resourceService.getResources()));
	}
	
	@GetMapping("/getResourcesByUid")
	public ResponseEntity<KomiaAjaxInfo> getResourcesByUid(int uid) {
		return ResponseEntity.ok(KomiaAjaxInfo.success(resourceService.getResourcesByUid(uid)));
	}
}
