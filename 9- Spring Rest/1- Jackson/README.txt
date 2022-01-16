- Jackson project provide data blinding. Through its ObjectMapper we can convert JSON to POJO and the opposite
- we can read JSON from a resource and convert it to object 
   1- We should provde getters and setters in this Object class
     Object1 o1 = ObjectMapper.readValue(JSON_source, Object1.class)
  2- We can also write objects as JSON 
    ObjectMapper.writeValue(output source, Object value)
- If we have fields doent match the json and we want to to ignore them while the mapping
We annotate the Object class with @JsonIgnoreProperties(ignoreUnknown = true)
- Spring Rest automatically applies Jackson (add jackson dependency)
