- Rest controller to define endpoints in the application annotated with @RestController
- GetMaping and PostMapping instead of the requstMapping to define endpoints
- we can add path variables to the requestMappings 
    @GetMapping("/endpoint/{index}") 
    someMethods(@PathVariable int index)
