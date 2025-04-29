package com.jpaToyProject.api.common.mail;
// package com.fav.fav.common.mail.controller;

// import javax.mail.MessagingException;

// import org.springframework.security.access.annotation.Secured;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.esg.mng.api.common.ProcessResult;
// import com.esg.mng.api.common.exception.BizErrorCode;
// import com.esg.mng.api.common.exception.BusinessException;
// import com.esg.mng.api.employeegroup.employee.data.model.EmployeeDTO;
// import com.esg.mng.api.mailService.data.model.MailServiceDTO;
// import com.esg.mng.api.mailService.service.MailServiceService;

// import lombok.RequiredArgsConstructor;
// import lombok.extern.slf4j.Slf4j;

// @Slf4j
// @RestController
// @RequestMapping("/api/mailService")
// @Secured({ "ROLE_SYSTEM", "ROLE_SERVICE", "ROLE_USER" })
// @RequiredArgsConstructor
// public class MailServiceController {
// 	private final MailServiceService emailService;
// 	private final String moduleName = "이메일 ";

// 	@PostMapping("/sendMail")
// 	public ProcessResult<MailServiceDTO> sendEmail(@RequestBody MailServiceDTO requestDTO) {
// 		String moduleFix = moduleName + "전송";
// 		ProcessResult<MailServiceDTO> processResult = null;

// 		try {
// 			int resultCode = emailService.sendMail(requestDTO);

// 			if (resultCode == 0) {
// 				processResult = ProcessResult.<MailServiceDTO>builder()
// 						.isResult(true)
// 						.resultCode(0)
// 						.resultMessage(String.format("%s > 성공", moduleFix))
// 						.build();
// 			} else {
// 				throw new BusinessException(BizErrorCode.MAIL_SEND_FAILED);
// 			}
// 		} catch (MessagingException e) {
// 			log.error("메일 전송 오류: {}", e.getMessage());
// 			processResult = ProcessResult.<MailServiceDTO>builder()
// 					.isResult(false)
// 					.resultCode(-1) // 실패 코드
// 					.resultMessage(String.format("%s > 실패 - 원인[%s]", moduleFix, e.getMessage()))
// 					.build();
// 		} catch (Exception e) {
// 			log.error("{}", e.getMessage());
// 			String message = BusinessException.getErrorMessage(e);
// 			processResult = ProcessResult.<MailServiceDTO>builder()
// 					.isResult(false)
// 					.resultCode(-1)
// 					.resultMessage(String.format("%s > 실패 - 원인[%s]", moduleFix, message))
// 					.build();
// 		} finally {
// 		}

// 		return processResult;
// 	}

// 	// @PostMapping("/sendNewPassword")
// 	// public ProcessResult<MailServiceDTO> sendNewPassword(@RequestBody EmployeeDTO requestDTO) {
// 	// 	String moduleFix = moduleName + "비밀번호 전송";
// 	// 	ProcessResult<MailServiceDTO> processResult = null;

// 	// 	try {
// 	// 		int resultCode = defaultService.sendNewPassword(requestDTO);

// 	// 		if (resultCode == 0) {
// 	// 			processResult = ProcessResult.<MailServiceDTO>builder()
// 	// 					.isResult(true)
// 	// 					.resultCode(0)
// 	// 					.resultMessage(String.format("%s > 성공", moduleFix))
// 	// 					.build();
// 	// 		} else {
// 	// 			throw new BusinessException(BizErrorCode.MAIL_SEND_FAILED);
// 	// 		}
// 	// 	} catch (MessagingException e) {
// 	// 		log.error("메일 전송 오류: {}", e.getMessage());
// 	// 		processResult = ProcessResult.<MailServiceDTO>builder()
// 	// 				.isResult(false)
// 	// 				.resultCode(-1) // 실패 코드
// 	// 				.resultMessage(String.format("%s > 실패 - 원인[%s]", moduleFix, e.getMessage()))
// 	// 				.build();
// 	// 	} catch (Exception e) {
// 	// 		log.error("{}", e.getMessage());
// 	// 		String message = BusinessException.getErrorMessage(e);
// 	// 		processResult = ProcessResult.<MailServiceDTO>builder()
// 	// 				.isResult(false)
// 	// 				.resultCode(-1)
// 	// 				.resultMessage(String.format("%s > 실패 - 원인[%s]", moduleFix, message))
// 	// 				.build();
// 	// 	} finally {
// 	// 	}

// 	// 	return processResult;
// 	// }

// }


// 현재 기능에는 controller가 필요 없어서 주석 처리.
// 구현 필요 시 DTO 작성 후 주석 해제