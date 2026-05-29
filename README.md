# Spring Modulith Observability Primitive Parameter Reproducer

Minimal Java reproducer for a Spring Modulith observability failure when rendering an observed module method that has a primitive parameter.

## Run

From this directory:

```bash
./gradlew bootRun
```

No database, broker, or Namastack dependencies are involved.

## Expected

The application should start, invoke the module service, log the call, and exit normally.

## Actual

With `spring-modulith-starter-insight` and Spring Modulith `2.1.0-SNAPSHOT`, the application fails while invoking:

```java
public void placeOrder(String sku, long amountCents)
```

The failure is:

```text
java.lang.StringIndexOutOfBoundsException: Range [0, 1) out of bounds for length 0
    at java.base/java.lang.String.substring(String.java:...)
    at org.springframework.modulith.core.FormattableType.lambda$new$0(FormattableType.java:74)
    at org.springframework.modulith.core.FormattableType.getAbbreviatedFullName(FormattableType.java:128)
    at org.springframework.modulith.observability.support.DefaultObservedModule.render(DefaultObservedModule.java:129)
    at org.springframework.modulith.observability.support.ModuleEntryInterceptor.invoke(ModuleEntryInterceptor.java:110)
```

The primitive `long` parameter has no package name. `FormattableType` tries to abbreviate the package name by taking the first character of each package segment, but the package name is empty for primitives.
