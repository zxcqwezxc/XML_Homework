# XML_Homework

Описание

Вашей программе на вход в качестве параметра запуска поступают .xml файлы - "input.xml" и "settings.xml"
Формат settings.xml

<settings>
    <array name="SomeArrayName"/>
    <attributeName value="SomeValue" />
<settings/>

Среди элементов входного файла найдется группирующий тег <SomeArrayName>, в котором будут произвольные по именам элементы с аттибутом "SomeValue".
Вам требуется записать в выходной xml файл - output.xml копию input.xml, в котором элементы внутри someArray будут отсортированы по значению SomeValue.
Пример:
Файл с настройками:
<settings>
    <array name="BookStore"/>
    <attributeName value="Author" />
<settings/>

Входной файл:
<xml>
<MyStoreDescription>This is my best store!
</MyStoreDescription>
<MyBooksCollection value="NotForResale"/>
<BookStore>
    <Book Author="Pushkin" Name="Captains Daughter"/>
    <Book Author="Lermontov" Name="Mtsyry"/>
</BookStore>
</xml>

Выходной файл:
<xml>
<MyStoreDescription>This is my best store!
</MyStoreDescription>
<MyBooksCollection value="NotForResale"/>
<BookStore>
    <Book Author="Lermontov" Name="Mtsyry"/>
    <Book Author="Pushkin" Name="Captains Daughter"/>
</BookStore>
</xml>
