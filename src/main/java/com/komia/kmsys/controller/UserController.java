package com.komia.kmsys.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.komia.common.KomiaAjaxInfo;
import com.komia.common.PageInfo;
import com.komia.kmsys.po.User;
import com.komia.kmsys.service.UserService;
import com.komia.kmsys.vo.UserSearchVo;
import com.komia.util.KomiaConstant;
import com.komia.util.KomiaUtil;


@RestController
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<KomiaAjaxInfo> getUsers(UserSearchVo userSearch) {
		PageInfo<User> pusers = userService.getAllUsers(userSearch);
		return ResponseEntity.ok(KomiaAjaxInfo.success(pusers));
	}
	
	@PostMapping("/add")
	public ResponseEntity<KomiaAjaxInfo> addUser(@Validated User user,BindingResult br) {
		if(br.hasErrors()) {
			HashMap<String,List<String>> errors = KomiaUtil.getErrorsMapList(br);
			return ResponseEntity.ok(KomiaAjaxInfo.fail(errors,KomiaConstant.ERROR_CODE_BADPARAM));
		}
		
		return ResponseEntity.ok(KomiaAjaxInfo.success(userService.add(user)));
	}
}
