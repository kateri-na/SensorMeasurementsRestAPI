## Всего в приложении 4 адреса:
1) Регистрация сенсора: POST /sensors/registration
   
  Если сенсор с таким названием есть в БД - возвращается клиенту сообщение с ошибкой.Также, если название сенсора пустое или содержит менее 3 или более 30 символов,клиенту возвращается сообщение с ошибкой.
  
  ![image](https://github.com/user-attachments/assets/21a180a3-6e17-4689-87c2-6a17255d695a)
  
2) Добавление измерения от сенсора: POST /measurements/add

  Значение "value" должно быть не пустым и находиться в диапазоне от -100 до 100. Значение "raining" должно быть не пустым. Происходит валидация сенсора в БД: сенсор с таким названием должен быть зарегистрирован в системе.Если такого сенсора нет в БД, выдается ошибка.
  
  ![image](https://github.com/user-attachments/assets/6bc0a6d8-6de4-450f-a3ca-4a893822aecd)
  
3) Получение всех измерений: GET /measurements
4) Получение количества дождливых дней: GET /measurements/rainyDaysCount
