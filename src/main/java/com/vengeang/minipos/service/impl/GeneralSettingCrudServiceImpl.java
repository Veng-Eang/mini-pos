package com.vengeang.minipos.service.impl;

import org.springframework.stereotype.Service;

import com.vengeang.minipos.dto.GeneralSettingDto;
import com.vengeang.minipos.entity.GeneralSetting;
import com.vengeang.minipos.exception.ResourceNotFoundException;
import com.vengeang.minipos.mapper.GeneralSettingMapper;
import com.vengeang.minipos.repository.GeneralSettingRepository;
import com.vengeang.minipos.service.GeneralSettingCrudService;

@Service
public class GeneralSettingCrudServiceImpl implements GeneralSettingCrudService {
	
	private final GeneralSettingRepository generalSettingRepository;
	private final GeneralSettingMapper generalSettingMapper;
	
	public GeneralSettingCrudServiceImpl(GeneralSettingRepository generalSettingRepository,GeneralSettingMapper generalSettingMapper) {
		this.generalSettingRepository = generalSettingRepository;
		this.generalSettingMapper = generalSettingMapper;
	}

	@Override
	public GeneralSettingDto save(GeneralSettingDto data) {
		GeneralSetting generalSetting = generalSettingRepository.save(generalSettingMapper.toGeneralSetting(data));
		return generalSettingMapper.toGeneralSettingDto(generalSetting);
	}

	@Override
	public GeneralSettingDto getById(Long id) {
		GeneralSetting generalSetting = generalSettingRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("General Setting", id));
		return generalSettingMapper.toGeneralSettingDto(generalSetting);
	}

	@Override
	public GeneralSettingDto updateById(Long id, GeneralSettingDto dataUpdate) {
		GeneralSetting generalSetting = generalSettingRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("General Setting", id));
		generalSetting.setSiteAddress(dataUpdate.getSiteAddress());
		generalSetting.setSiteLogo(dataUpdate.getSiteLogo());
		generalSetting.setSitePhone(dataUpdate.getSitePhone());
		generalSetting.setSiteTitle(dataUpdate.getSiteTitle());
		generalSetting = generalSettingRepository.save(generalSetting);
		return generalSettingMapper.toGeneralSettingDto(generalSetting);
	}


	@Override
	public void deleteById(Long id) {
		GeneralSetting generalSetting = generalSettingRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("General Setting", id));
		generalSettingRepository.delete(generalSetting);
		System.out.println("delete success");
	}

	@Override
	public GeneralSettingDto softDeleteById(Long id) {
		GeneralSetting generalSetting = generalSettingRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("General Setting", id));
		generalSetting.setIsDeleted(true);
		generalSetting = generalSettingRepository.save(generalSetting);
		return generalSettingMapper.toGeneralSettingDto(generalSetting);
	}
}
