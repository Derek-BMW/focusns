/*
 * Copyright (C) 2011-2013 FocusSNS.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package org.focusns.web.widget.engine;

import org.focusns.web.widget.WidgetRequest;
import org.focusns.web.widget.WidgetResponse;

import java.lang.reflect.Method;

public abstract class WidgetInvoker {
	
	private String code;
	private Object target;
	private Method method;
	private WidgetRequest request;
	private WidgetResponse response;
	private WidgetViewResolver viewResolver;
	private WidgetParameterResolver parameterResolver;
	
	public WidgetInvoker(Object target, Method method, WidgetRequest request, 
			WidgetResponse response, WidgetViewResolver viewResolver, 
			WidgetParameterResolver parameterResolver) {
		this.target = target;
		this.method = method;
		this.request = request;
		this.response = response;
		this.viewResolver = viewResolver;
		this.parameterResolver = parameterResolver;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public Object getTarget() {
		return target;
	}
	
	public Method getMethod() {
		return method;
	}
	
	public WidgetRequest getRequest() {
		return request;
	}
	
	public WidgetResponse getResponse() {
		return response;
	}
	
	public WidgetViewResolver getViewResolver() {
		return viewResolver;
	}
	
	public WidgetParameterResolver getParameterResolver() {
		return parameterResolver;
	}
	
	public abstract void invoke() throws Exception;
	
}
