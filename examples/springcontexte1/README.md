## Context
It is a container contain collection of instances managed by spring framework. Any object need to know and managed by sping then we have to put in context

## How to create beans with spring framework?
- XML
- Annotations

## @Configuration


## @Bean
method inside class

## @PostConstruct
method call after the construction of Object
Those object not part of context can not call method annotated with @PostConstruct 

## @Component
with this way, we can not create more than one instance of type

## @Service

## @Repository

## @Autowired
instruct spring to take object from context and inject in to the reference.

### Field
```java
    @Autowired
    private ProductRepository productRepository;
```

### Constructor

we use it if we want to make our field final
control over construction of object
```java
    private final ProductRepository productRepository;
    
    @Autowired
    public ProductDeliveryServices(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
```

### Setter Method
```java
    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
```