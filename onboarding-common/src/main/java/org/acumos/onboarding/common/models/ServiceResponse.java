/*-
 * ===============LICENSE_START=======================================================
 * Acumos
 * ===================================================================================
 * Copyright (C) 2017 AT&T Intellectual Property & Tech Mahindra. All rights reserved.
 * ===================================================================================
 * This Acumos software file is distributed by AT&T and Tech Mahindra
 * under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * This file is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ===============LICENSE_END=========================================================
 */

package org.acumos.onboarding.common.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * used to set the status
 *
 */
@javax.xml.bind.annotation.XmlRootElement
@JsonInclude(Include.NON_NULL)

public class ServiceResponse {
	private String status;

	private String errorCode;

	private String errorMessage;

	private String jwtToken;

	private Object result;

	public static final String sStatus = "SUCCESS";

	public ServiceResponse() {
		// Default Constructor
	}

	public static ServiceResponse errorResponse(String errorCode, String errorMessage) {
		ServiceResponse error = new ServiceResponse();
		error.setStatus("ERROR");
		error.setErrorCode(errorCode);
		error.setErrorMessage(errorMessage);
		return error;
	}

	public static ServiceResponse successResponse() {
		ServiceResponse success = new ServiceResponse();
		success.setStatus(sStatus);
		return success;
	}

	public static ServiceResponse successResponse(Object result) {
		ServiceResponse success = new ServiceResponse();
		success.setStatus(sStatus);
		success.setResult(result);
		return success;
	}

	public static ServiceResponse successJWTResponse(String jwtToken) {
		ServiceResponse token = new ServiceResponse();
		token.setStatus(sStatus);
		token.setJwtToken(jwtToken);
		return token;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{status=" + status);
		if (this.errorCode != null) {
			sb.append(", errorCode=" + errorCode + ", errorMessage=" + errorMessage);
		}
		if (this.result != null) {
			sb.append(", result=" + result);
		}
		if (this.jwtToken != null) {
			sb.append(", jwtToken=" + jwtToken);
		}
		sb.append("}");
		return sb.toString();
	}

}
