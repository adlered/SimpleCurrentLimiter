### [English README](#English)

## 获得帮助

:construction_worker: 如果你对该项目的使用有无法解决的疑问，欢迎向我提问。请在我的资料中找到联系方式，我会及时回复。

## SimpleCurrentLimit

SimpleCurrentLimit可以指定：

在`X`秒内，同字符串只允许访问`Y`次。

通常用于WEB项目，IP地址就是一串字符串

首先，从[这里](https://github.com/AdlerED/SimpleCurrentLimiter/releases)下载最新的Jar包，并引入到你的项目中。

假设，我们设置每个IP地址（或任意字符串）在2秒内只能访问1次，实例化SimpleCurrentLimit代码如下：

```
// 在实例化时指定2秒内只能访问1次
SimpleCurrentLimiter simpleCurrentLimiter = new SimpleCurrentLimiter(2, 1);
```

那么如何实现对IP地址的控制呢？

每次该IP地址（或任意字符串）访问时，调用SimpleCurrentLimiter的`access(String str)`方法：

```
boolean result;
result = simpleCurrentLimiter.access("127.0.0.1");
System.out.println("IP Access: 127.0.0.1, passed: " + result);
```

`access(String str)`方法传入字符串，并返回Boolean值，为false时，说明该字符串已超出限制，为true时代表该字符串允许通过。

### 实例测试：

```
try {
    SimpleCurrentLimiter simpleCurrentLimiter = new SimpleCurrentLimiter(2, 1);
    boolean result;
    result = simpleCurrentLimiter.access("127.0.0.1");
    System.out.println("IP Access: 127.0.0.1, passed: " + result);
    Thread.sleep(500);
    result = simpleCurrentLimiter.access("1.1.1.1");
    System.out.println("IP Access: 1.1.1.1, passed: " + result);
    Thread.sleep(500);
    result = simpleCurrentLimiter.access("127.0.0.1");
    System.out.println("IP Access: 127.0.0.1, passed: " + result);
    Thread.sleep(500);
} catch (InterruptedException IE) {}
```

返回结果：

```
IP Access: 127.0.0.1, passed: true
IP Access: 1.1.1.1, passed: true
IP Access: 127.0.0.1, passed: false
```

`127.0.0.1`在2秒内访问了2次，第一次返回`true`即通过，第二次会被拒绝，返回`false`。

`1.1.1.1`在2秒内只有一次访问，所以直接返回`true`。

# English

## Getting help

:construction_worker: If you have any questions about the use of this project, please feel free to ask me questions. Please find the contact information in my profile and I will respond promptly.

## SimpleCurrentLimit

SimpleCurrentLimit can specify:

Within `X` seconds, the same string is only allowed to access `Y` times.

Usually used for WEB projects, the IP address is a string of strings

First, download the latest Jar package from [here] (https://github.com/AdlerED/SimpleCurrentLimiter/releases) and import it into your project.

Assume that we set each IP address (or any string) to be accessed only once in 2 seconds. Instantiate the SimpleCurrentLimit code as follows:

```
// can only be accessed once within 2 seconds when instantiating
SimpleCurrentLimiter simpleCurrentLimiter = new SimpleCurrentLimiter(2, 1);
```

So how do you implement control over IP addresses?

Each time the IP address (or any string) is accessed, the SimpleCurrentLimiter's `access(String str)` method is called:

```
boolean result;
result = simpleCurrentLimiter.access("127.0.0.1");
System.out.println("IP Access: 127.0.0.1, passed: " + result);
```

The `access(String str)` method passes in a string and returns a Boolean value. When it is false, it indicates that the string has exceeded the limit. When true, it means that the string is allowed to pass.

### Instance test:

```
try {
    SimpleCurrentLimiter simpleCurrentLimiter = new SimpleCurrentLimiter(2, 1);
    boolean result;
    result = simpleCurrentLimiter.access("127.0.0.1");
    System.out.println("IP Access: 127.0.0.1, passed: " + result);
    Thread.sleep(500);
    result = simpleCurrentLimiter.access("1.1.1.1");
    System.out.println("IP Access: 1.1.1.1, passed: " + result);
    Thread.sleep(500);
    result = simpleCurrentLimiter.access("127.0.0.1");
    System.out.println("IP Access: 127.0.0.1, passed: " + result);
    Thread.sleep(500);
} catch (InterruptedException IE) {}
```

Return results:

```
IP Access: 127.0.0.1, passed: true
IP Access: 1.1.1.1, passed: true
IP Access: 127.0.0.1, passed: false
```

`127.0.0.1` has been accessed 2 times in 2 seconds, the first time to return `true` is passed, the second time will be rejected, return `false`.

`1.1.1.1` has only one access in 2 seconds, so return `true` directly.