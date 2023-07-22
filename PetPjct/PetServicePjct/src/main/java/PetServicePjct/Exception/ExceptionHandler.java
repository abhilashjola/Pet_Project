package PetServicePjct.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleDefaultException(MethodArgumentNotValidException manvi)throws MethodArgumentNotValidException{
		
		Map<String, String> errorMap=new HashMap<>();
		manvi.getBindingResult().getFieldErrors().forEach(error ->{ 
		errorMap.put(error.getDefaultMessage(), error.getField());
		
		});
		return errorMap;
		}
	

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@org.springframework.web.bind.annotation.ExceptionHandler(UserExistException.class)
	public Map<String, String> handleExeption(UserExistException uee)throws UserExistException{
		
		Map<String, String> errorMap=new HashMap<>();
		errorMap.put("ErrorMessage", uee.getMessage());
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@org.springframework.web.bind.annotation.ExceptionHandler(PasswordNotMatched.class)
	public Map<String, String> handlePasswordException(PasswordNotMatched pnm)throws PasswordNotMatched{
		Map<String, String> errorMap=new HashMap<>();
		errorMap.put("ErrorMessage", pnm.getMessage());
		return errorMap;
	}
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@org.springframework.web.bind.annotation.ExceptionHandler(UserDoesNotExist.class)
	public Map<String, String> handleDoesNotExistException(UserDoesNotExist udne){
	
		Map<String, String> errorMap=new HashMap<>();
		errorMap.put("ErrorMessage", udne.getMessage());
		return errorMap;
	
	
	}
}
