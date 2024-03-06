# epay

彩虹易支付系统是一个虚拟支付系统，用于在线支付和电子交易。它提供了一种安全、方便的支付方式，用户可以使用它进行网上购物、账单支付等。通常，这种系统会与银行、支付网关和商户合作，以确保支付过程的顺利进行，并保护用户的支付信息安全。彩虹易支付系统通常支持多种支付方式，如信用卡、借记卡、电子钱包等，以满足用户的不同需求。

## 项目说明

这里的代码仅仅是一个sdk的源码，并不是应用，实际应用需要引用该项目并使用

## 项目引入

项目本地本地打包：mvn clean install -Dmaven.test.skip=true

如果是本地环境打入jar包或者将jar包放入了私有仓库：

```
        <dependency>
            <groupId>com.lcy</groupId>
            <artifactId>epay-sdk</artifactId>
            <version>1.0.0</version>
            <scope>system</scope>
            <systemPath>${pom.basedir}/src/main/resources/lib/epay-sdk-1.0.0.jar</systemPath>
        </dependency>
```

项目里拷贝jar包，并引用

```
        <dependency>
            <groupId>com.lcy</groupId>
            <artifactId>epay-sdk</artifactId>
            <version>1.0.0</version>
            <scope>system</scope>
            <systemPath>${pom.basedir}/src/main/resources/lib/epay-sdk-1.0.0.jar</systemPath>
        </dependency>
```

## 项目使用

使用方式：

```
        //创建
        EpayService epayService = new EpayService(url,pid,key);
        //发起支付
        PayResponse pay = epayService.pay(payRequest);
```

## 接口支持

主要操作类为EpayService

| 接口类型           | 接口方法        |
| ------------------ | --------------- |
| 发起支付           | pay             |
| 异步回调处理接口   | asyncNotify     |
| 商户订单号查询订单 | queryOrder      |
| 批量查询订单       | queryBatchOrder |

