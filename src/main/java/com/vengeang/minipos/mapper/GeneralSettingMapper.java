package com.vengeang.minipos.mapper;

import org.mapstruct.Mapper;

import com.vengeang.minipos.dto.GeneralSettingDto;
import com.vengeang.minipos.entity.GeneralSetting;

@Mapper(componentModel = "spring")
public interface GeneralSettingMapper {

	GeneralSettingDto toGeneralSettingDto(GeneralSetting generalSetting);
	GeneralSetting toGeneralSetting(GeneralSettingDto generalSettingDto);
}
