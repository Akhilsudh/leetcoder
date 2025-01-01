# Annotations

## Controller annotations
1. `@Controller`: Makes sure that the given class is part of the HTTP request
2. `@ResponseBody`: Makes sure that the method returns a HTTP response
3. `@RestController`: it is `@Controller` + `@ResponseBody`
   ![img_10.png](img_10.png)
4. `@RequestParam`: used to bind the path params to the controller method
   ![img_11.png](img_11.png)
   - Primitive type casting
   - Wrapper classes type casting
   - String casting
   - Enums
   - Custom object types using a registered property editor
   - ![img_12.png](img_12.png)
5. `@PathVariable`: This annotation is to map a path variable in the api path like `url/{PATH_VARIABLE}`
6. `@RequestBody`: This annotation is to map the request body to a DTO. Spring Boot uses GSON/Jackson
   ![img_13.png](img_13.png)
7. `ResponseEntity`: It represents the entire HTTP response. We can select the status code and then the JSON.
   ![img_14.png](img_14.png)
   - `@Controller`Here we need to internally create a @ResponseBody else it will be returning the actual datatype and not HTTP response. wheras in `@RestController` it will wrap the output as `ResponseEntity`.

## Other annotations
### `@ConditionalOnProperty`
Bean is created confditionally based on some flag. Consider the following case:
![img_30.png](img_30.png)

Now consider two use cases:
1. If we have a requirement to create only one of the two beans (In case company decides to migrate from sql to nosql)
2. If some part of code uses NoSql and some uses Sql, then it is better to chose at runtime which connection bean needs to be created.

To implement these use cases we first implement the components as follows:
![img_31.png](img_31.png)

We then use the key in app props file to determine what your app needs:
![img_32.png](img_32.png)

Now in the common code we can implement it like this:
![img_33.png](img_33.png)

#### Advantages
1. Feature toggling is introduced
2. Avoid cluttered application context with uneeded beans
3. Save memory
4. Reduce start up time

#### Disadvantages
1. Misconfiguration can happen
2. Code complexity increases when over used across many classes. Needs to be used with caution.

### `@Transactional`
This helps in handling DB transactions to follow ACID props.

First point cut expression `@Transaction is hit`
Then advise is to run the interceptor
![img_34.png](img_34.png)

Then if exception happens we rollback else we commit