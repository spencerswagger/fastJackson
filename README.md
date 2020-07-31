# FastJackson

This project inspired by FastJson of Alibaba.

Add this project if you are used to using JSON static method of FastJSON,
but you have to use Jackson for some purpose(eg.Globally unified settings of spring)

This project provides a static way to serialize/deserialize json,
and a dozen of features to configure ObjectMapper of Jackson.

# How to install

This project have not uploaded to maven repository yet. 

Please download the `fastJackson-0.0.1.jar` under the `target` folder.

# How to use

Serialize an object to json string.
````
    JSON.toString(object);
````

Deserialize json string to an object of the specified type.
````
    JSON.parse(jsonString,TargetType.class);
````

## Featured serialize/deserialize

Serialize an object to json string with feature.
eg.serialize LocalDateTime to String by ISO8601 formatter.
````
    JSON.toString(LocalDateTime.now(),Features.Dates.USE_ISO8601);
````

Deserialize json string to an object with feature.
eg.deserialize String to LocalDateTime by ISO8601 formatter.
````
    JSON.parse("2020-01-01T00:00:000",LocalDateTime.class,Features.Dates.USE_ISO8601);
````

## Build a ObjectMapper
###Preset ObjectMapper
Build a default ObjectMapper.
````
    JsonUtils.buildMapper()
````
*It returns an ObjectMapper with some preset features.(see JsonObjectMapper)*
###ObjectMapper with more features
Build an ObjectMapper with preset features and more features.
eg.ObjectMapper with ISO8601 formatter.
````
    JsonUtils.getFeaturedMapper(Features.Dates.USE_ISO8601_SERIALIZER,Features.USE_ISO8601_DESERIALIZER);
````
**The custom features will override the preset features,
just like ISO8601 features override the preset time format features**

*It effects the same as `Features.Dates.USE_ISO8601`*

# How to build a feature
## Jackson features
We can use Jackson features like this.
````
    Feature.of(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
````
*It effects the same as:*
````
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
````
It supports `SerializationFeature`,`DeserializationFeature`,`MapperFeature`,`JsonParser.Feature`,`JsonGenerator.Feature`.

## Built-in features
This project provides some built-in features,you can find them in Features.(eg.USE_ISO8601)
````
    Features.Dates.USE_ISO8601;
    Features.Enums.USE_TO_STRING;
    Features.Enums.USE_ORDINAL;
    ...
````
## Custom features
We can implement Feature interface to build a Feature.
````java
    import com.fcy.common.jackson.feature.Feature;
    class MyFeature implements Feature{
        void modify(JsonObjectMapper objectMapper){
            //do something to objectMapper
        }   
    }
````

We can also use SerializeFeature/DeserializeFeature static method to build a Feature.
````
    //serialize Enum by toString
    SerializeFeature.of(Enum.class,Enum::toString);
    //deserialize Date by ISO formatter
    DeserializeFeature.of(Date.class,s -> Date.from(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(s, Instant::from))),
````

#Other function
There are some more other functions that I'm using.Maybe you need them too.
## CodeSerializable
Sometimes we'll give an object(eg.Enum) a `code` property,and we'd like to serialize it by code value.
Implement CodeSerializable interface, then its all done.
````
    @AllArgsConstructor
    enum CodeEnum implements CodeSerializable{
        A("000"),B("001");
        @Getter
        private String code;
    }
    public static void main(String[] args){
        //"000"
        JSON.toString(CodeEnum.A) 
        //CodeEnum.B
        JSON.parse("001",CodeEnum.class)
    }
````
*In fact, it works by @JsonValue of Jackson*

**Only Enum object implements CodeSerializable interface will deserialize by code,
because Jackson did some work for Enum deserialization**