# User Service

## Описание

**User Service** — это Java приложение для управления пользователями с использованием Hibernate ORM и PostgreSQL. Приложение предоставляет полный CRUD функционал для работы с пользователями через интерактивное меню в консоли.

## Технологический стек

- **Java 17** — основной язык программирования
- **Hibernate 6.5.2** — ORM фреймворк для работы с базой данных
- **PostgreSQL 16** — реляционная база данных
- **SLF4J + Logback** — логирование
- **Lombok 1.18.38** — уменьшение boilerplate кода
- **JUnit 5** — юнит-тесты
- **Testcontainers** — интеграционные тесты с Docker контейнерами
- **Maven** — управление проектом и зависимостями
- **Docker & Docker Compose** — контейнеризация и оркестрация

## Структура проекта

```
src/
├── main/
│   ├── java/ru/astondevs/
│   │   ├── users/
│   │   │   ├── config/         # Конфигурация Hibernate
│   │   │   ├── dao/            # Data Access Objects
│   │   │   ├── entity/         # JPA сущности (User)
│   │   │   └── Main.java       # Точка входа
│   │   └── Main.java
│   └── resources/
│       └── hibernate.cfg.xml
└── test/
    └── java/ru/astondevs/users/dao/  # Тесты DAO
```

## Компоненты приложения

### User Entity
Сущность пользователя с полями:
- `id` — уникальный идентификатор
- `name` — имя пользователя
- `email` — электронная почта
- `age` — возраст

### UserDao & UserDaoImpl
Интерфейс и реализация DAO для операций с пользователями:
- `create()` — сохранение нового пользователя
- `read()` — получение пользователя по ID
- `update()` — обновление данных
- `delete()` — удаление
- `getAll()` — получение всех пользователей

### HibernateUtil
Утилита для манагжмента `SessionFactory` Hibernate.

## Установка и запуск

### Требования
- Java 17+
- Maven 3.6+
- Docker и Docker Compose

### Локальный запуск

1. **Клонируйте репозиторий:**
   ```bash
   git clone https://github.com/iDolph1n/user_service.git
   cd user_service
   ```

2. **Запустите PostgreSQL:**
   ```bash
   docker-compose up -d
   ```

3. **Соберите проект:**
   ```bash
   mvn clean install
   ```

4. **Запустите приложение:**
   ```bash
   mvn exec:java -Dexec.mainClass="ru.astondevs.Main"
   ```

## Основное меню аппликации

После запуска появляется интерактивное меню:

```
=============== МЕНИ ===============
1. Сохранить пользователя
2. Получить пользователя по ID
3. Обновить пользователя
4. Удалить пользователя
5. Получить всех пользователей
6. Выход
```

## Тестирование

### Запуск тестов

```bash
mvn test
```

Тесты используют **Testcontainers** для автоматического запуска PostgreSQL контейнера.

## Конфигурация базы данных

### Docker Compose

```yaml
services:
  postgres:
    image: postgres:16
    environment:
      POSTGRES_DB: user_service
      POSTGRES_USER: user
      POSTGRES_PASSWORD: password
    ports:
      - "5432:5432"
    volumes:
      - user_db_data:/var/lib/postgresql/data

volumes:
  user_db_data:
```

## Потенциальные улучшения

- [ ] REST API с Spring Boot
- [ ] Сервисный слой (UserService)
- [ ] Валидация данных
- [ ] Миграции БД (Liquibase/Flyway)
- [ ] CI/CD пайплайн

## Лицензия

Этот проект распространяется под лицензией MIT. MIT License - это пермиссивная лицензия с открытым исходным кодом, которая позволяет:

- Использовать код в коммерческих целях
- Модифицировать и распространять код
- Использовать в закрытых проектах
- Использовать с заявлением об отказе от ответственности

Полный текст лицензии находится в файле [LICENSE](LICENSE) в корневой директории проекта.

Copyright (c) 2025 iDolph1n

## Автор

[iDolph1n](https://github.com/iDolph1n)
