Handling exceptions
Instead of retruning the execption error on html page,we return the exception as JSON with custom error respponse
1- Create a custome error response class (StudentErrorResponse)
2- create a custom exception class (StudentNotFoundException) extends the RuntimeException
3- throw exception int the rest class if student not found: throw new (StudentNotFoundException)
4- add an exception handler useing @ExceptionHandler to handle the excepion
We annotate the method with @ExceptionHandler 
the method return a ResponseEntity which is a wrapper for http response 
the type of its body is (StudentErrorResponse) and handle the (StudentNotFoundException) exception

- We can use @ControllerAdvice to handle global exceptions that happen in all controllers
@ControllerAdvice
Real time use of AOP 
pre process requests to controllers
post- process reponses to handle exception 
perferct for global exception handling
We simply add an new class and annotate with @ControllerAdvice and put the Exceptionhandling process in it
     
