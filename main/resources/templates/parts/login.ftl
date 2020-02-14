<#macro login path isRegisterForm>
<form action="${path}" method="post">

    <div class="form-group row">
        <div class="col-sm-2"></div>
        <label class="col-sm-2 col-form-label">Email :<span class="red">*</span></label>
        <div class="col-sm-6">
            <input type="email" name="username" class="form-control" placeholder="mymail@mail.com" required/>
        </div>
    </div>

    <div class="form-group row">
        <div class="col-sm-2"></div>
        <label class="col-sm-2 col-form-label">Пароль:<span class="red">*</span></label>
        <div class="col-sm-6">
            <input type="password" name="password" class="form-control" placeholder="Password" required/>
        </div>
    </div>

    <#if isRegisterForm>
        <div class="form-group row">
            <div class="col-sm-2"></div>
            <label class="col-sm-2 col-form-label">Имя:<span class="red">*</span></label>
            <div class="col-sm-6">
                <input type="firstname" name="firstname" class="form-control" placeholder="Имя" required/>
            </div>
        </div>
     </#if>

    <#if isRegisterForm>
        <div class="form-group row">
            <div class="col-sm-2"></div>
            <label class="col-sm-2 col-form-label">Фамилия:<span class="red">*</span></label>
            <div class="col-sm-6">
                <input type="lastname" name="lastname" class="form-control" placeholder="Фамилия" required/>
            </div>
        </div>
    </#if>


    <#if isRegisterForm>
        <div class="form-group row">
            <div class="col-sm-2"></div>
            <label class="col-sm-2 col-form-label">Телефон:<span class="red">*</span></label>
            <div class="col-sm-6">
                <input type="text" name="phonenumber" class="form-control" placeholder="+X (XXX) XXX XX XX" required/>
            </div>
        </div>
    </#if>


    <#if isRegisterForm>
        <div class="form-group row">
            <div class="col-sm-2"></div>
            <label class="col-sm-2 col-form-label">Секция:<span class="red">*</span></label>
            <div class="col-sm-6">
                <select type="section" name="section" class="form-control" атрибуты>
                    <option атрибуты>Законодательная база и аналитика</option>
                    <option атрибуты>Редевелопмент в Петербурге</option>
                    <option атрибуты>Развития транспортной инфраструктуры</option>
                    <option атрибуты>Общественные пространства</option>
                </select>
            </div>
        </div>
    </#if>

    <#if isRegisterForm>
        <div class="form-group row">
            <div class="col-sm-2"></div>
            <label class="col-sm-2 col-form-label">Дата:<span class="red">*</span></label>
            <div class="col-sm-6">
                <select type="date" name="date" class="form-control" атрибуты>
                    <option атрибуты>01.03.2020</option>
                    <option атрибуты>02.04.2020</option>
                    <option атрибуты>10.05.2020</option>
                    <option атрибуты>12.09.2020</option>
                </select>
            </div>
        </div>
    </#if>

    <#if isRegisterForm>
    <div class="form-group row">
        <div class="col-sm-2"></div>
         <label class="col-sm-2 col-form-label">Статус:<span class="red">*</span></label>
                <div class="col-sm-6 mt-2">
                <div class="form-check form-check-inline">
                     <input class="form-check-input" type="radio" name="status" id="exampleRadios1" value="Speaker" checked>
                     <label class="form-check-label" for="exampleRadios1">С докладом</label>
                </div>

            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="status" id="exampleRadios2" value="Listener">
                <label class="form-check-label" for="exampleRadios2">Без доклада</label>
            </div>
                </div>
    </div>


    </#if>

    <input type="hidden" name="_csrf" value="${_csrf.token}" />

    <div class="form-group row">
        <div class="col-sm-2"></div>
            <div class="col-sm-2 mt-2">
                <button class="btn btn-secondary" type="submit"><#if isRegisterForm>Подтвердить<#else>Войти</#if></button>
                <div class="col-sm-6 mt-2">
                    <#if !isRegisterForm>
                    <div class="form-group row">
                        <a href="/registration">Зарегистрироваться</a>
                    </div>
                </#if>

            </div>
    </div>



    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-secondary mt-3" type="submit">Выйти</button>
    </form>
</#macro>