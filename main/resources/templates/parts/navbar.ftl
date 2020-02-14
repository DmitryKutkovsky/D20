<#include "security.ftl">
<#import "login.ftl" as l>
<div class="container">
    <div class="py-5 text-center">
        <img class="rounded mb-4" src="https://i.ibb.co/KLvF79P/conf-top1.png"  alt="" width="960" height="100">
        <h2>Конференция «Практическое строительство»</h2>
        <p class="lead">B2B мероприятие компании «Ярмарка нредвижимости»  проводится в КВЦ «Экспофорум» четыре раза в год.</p>


        <#if name !=" ">
            <div class="py-2 text-center">Зравствуйте, ${firstname}</div>
        </#if>

        <#if name =" ">
            <a href="/login">Войти или зарегистрироварться</a>
        </#if>

        <#if isAdmin>
            <a href="/user">Список участников </a>
        </#if>

        <#if name !=" ">
            <a href="/main">Список докладчиков</a>
        </#if>

       <#if name !=" ">
            <@l.logout/>
       </#if>




