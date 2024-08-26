package com.vengeang.minipos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vengeang.minipos.dto.GeneralSettingDto;
import com.vengeang.minipos.service.GeneralSettingCrudService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/general_setting")
public class GeneralSettingController {
	private final GeneralSettingCrudService generalSettingCrudService;
	@PostMapping
	ResponseEntity<GeneralSettingDto> create(@RequestBody @Validated GeneralSettingDto companyDto){
		return ResponseEntity.ok(generalSettingCrudService.save(companyDto));
	}
	@GetMapping("{id}")
	ResponseEntity<GeneralSettingDto> getById(@PathVariable Long id){
		return ResponseEntity.ok(generalSettingCrudService.getById(id));
	}
	
	
	@PutMapping("{id}")
	ResponseEntity<GeneralSettingDto> updateById(@PathVariable Long id,@RequestBody @Validated GeneralSettingDto settingUpdate){
		return ResponseEntity.ok(generalSettingCrudService.updateById(id, settingUpdate));
	}
	
	@DeleteMapping("{id}")
	ResponseEntity<String> deleteById(@PathVariable Long id){
		generalSettingCrudService.softDeleteById(id);
		return ResponseEntity.ok("Move customer with id : "+id+" to trash success.");
	}
}
