package com.jpaToyProject.api.common;

import java.util.List;

import com.jpaToyProject.api.common.exception.ValidationException.ValidationError;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProcessResult<T> {
	private boolean isResult;
	private int resultCode;	
	private String resultMessage;
	
	private T excelResult;
	private String resultString;
	private List<T> resultList;
	private List<ValidationError> validationList;
	private Pagination pagination;
}