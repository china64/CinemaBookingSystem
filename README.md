# 🎬 Cinema Booking System - Backend

這是一個基於 **Spring Boot** 的電影訂票系統後端應用程式，提供 API 來管理電影、影廳、訂單等資訊。

## 📌 專案架構

- **Spring Boot** - 核心框架
- **Spring Data JPA** - 資料庫操作
- **H2/MySQL** - 預設為 H2，可切換為 MySQL
- **Lombok** - 簡化 Java 物件
- **MapStruct** - DTO 轉換工具
- **Maven** - 構建和依賴管理

## 🚀 環境設置

### 1. 安裝必要工具
- [JDK 17+](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [MySQL (可選)](https://www.mysql.com/)

### 2. 克隆專案
```sh
git clone https://github.com/你的GitHub帳號/CinemaBookingSystem_Backend.git
cd CinemaBookingSystem_Backend
```

### 3. 建置與運行
```sh
# 透過 Maven 啟動專案
./mvnw spring-boot:run
```
或
```sh
mvn spring-boot:run
```

應用程式將運行在 `http://localhost:8080`

## 📂 目錄結構

```
CinemaBookingSystem_Backend
├── src
│   ├── main
│   │   ├── java/com/myproject/cinemabookingsystem_backend
│   │   │   ├── controller/    # API 控制器
│   │   │   ├── service/       # 業務邏輯層
│   │   │   ├── model/         # 資料庫模型
│   │   │   ├── DTO/           # 資料傳輸物件
│   │   │   ├── mapper/        # DTO 轉換
│   │   │   ├── utils/         # 工具類別
│   │   │   ├── CinemaBookingSystemBackendApplication.java  # 主應用程式
│   │   ├── resources
│   │   │   ├── application.properties  # 設定檔
├── pom.xml     # Maven 設定檔
├── .gitignore  # Git 忽略設定
└── README.md   # 本文件
```

## 🔧 API 測試
你可以使用 **Postman** 或 **Swagger** 來測試 API。

### 預設 API 端點
| 方法 | 路徑 | 說明 |
|------|------|------|
| GET  | `/movies` | 獲取所有電影 |
| POST | `/movies` | 新增電影 |
| GET  | `/bookings` | 查詢訂單 |
| POST | `/bookings` | 建立訂單 |

## 💡 貢獻
歡迎提交 PR 或 Issue，讓這個專案變得更好！

## 📝 授權
本專案採用 MIT License。
