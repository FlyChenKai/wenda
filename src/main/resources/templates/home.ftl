<#--模板-->

<html>
    hello
   ${value1!"null"}
    ${value2!"null"}
    ${list[1]}

    <br>

    <#--遍历list-->
<#list list as being>
    <tr>
        <td>${being}<td>
        <br>
    </tr>
</#list>

 <#--遍历map-->
<#if map?exists>
    <#list map?keys as key>
                   <tr>
                       <td>${key}</td>
                       <td>${map[key]}</td>
                       <br>
                   </tr>
    </#list>
</#if>

    ${user.setName("wo")}
${user.getName()}

    <#--新建变量-->
<#assign x=1>
    ${x}
</html>