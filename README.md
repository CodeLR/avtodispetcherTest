# avtodispetcherTest
javaTest

В данном проекте существует 5 тестов. Которые повторяют сценарий для автоматизации:
1. Пользователь заходит на сайт Яндекс: www.yandex.ru
2. Вводит в поисковую строку фразу «расчет расстояний между городами» и запускает поиск
3. Среди результатов поиска пользователь ищет результат с сайта «avtodispetcher.ru»
4. Найдя нужный результат с этого сайта – пользовать кликает на данном результате и переходит
на сайт www.avtodispetcher.ru/distance/
5. Убедившись, что открылась верная ссылка, пользователь вводит следующие значения в поля:
a. Поле «Откуда» - «Тула»
b. Поле «Куда» - «Санкт-Петербург»
c. Поле «Расход топлива» - «9»
d. Поле «Цена топлива» - «46»
6. Пользователь нажимает кнопку «Рассчитать»
7. Пользователь проверяет что рассчитанное расстояние = 897 км, а стоимость топлива =
3726 руб.
8. Пользователь кликает на «Изменить маршрут»
9. В открывшейся форме в поле «Через города» вводит «Великий Новгород»
10. Ждет минуту и снова нажимает «Рассчитать»
11. Пользователь проверяет что расстояние теперь = 966 км, а стоимость топлива = 4002 руб.

В данной работе я много потратил времени на установку. VS не хотел работать.

Что у меня не получилось.!
1) Пока целевой элемент не появится на странице. Даже время загрузки в доли секунд может сломать автотест.(Нужно постоянно передвигать мышку чтобы объект был в зоне видимости)
2)У меня не работает нормально wait. - > 
3)не могу добраться до function fuelFormSubmitHandler(fuelForm) чтобы получить данные. 
