package com.komia.kmsys.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.komia.common.KomiaAjaxInfo;
import com.komia.util.KomiaConstant;
import com.komia.util.RSAUtil;

@RestController
@RequestMapping(value= KomiaConstant.COMMON_URL)
public class CommonController {
	private Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@GetMapping(value="/publickey")
	public ResponseEntity<KomiaAjaxInfo> getLoggedUser() {
		String publickey= RSAUtil.PUBLIC_KEY;
		return ResponseEntity.ok(KomiaAjaxInfo.success(publickey));
	}
}
