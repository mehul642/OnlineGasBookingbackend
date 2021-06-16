package com.cg.gasbooking.exception;

import org.springframework.stereotype.Component;

@Component
public class SurrenderBusinessException extends RuntimeException  {
         private String errormessage;

		public String getErrormessage() {
			return errormessage;
		}

		public void setErrormessage(String errormessage) {
			this.errormessage = errormessage;
		}

		public SurrenderBusinessException(String errormessage) {
			super();
			this.errormessage = errormessage;
		}

		public SurrenderBusinessException() {
		
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "BusinessController [errormessage=" + errormessage + "]";
		}
         
         
}
