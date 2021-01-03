package com.ikuta.dao;

import com.ikuta.po.Student;
import com.ikuta.vo.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    // [一个参数]使用简单参数类型
    Student selectStudentById(@Param("studentId") Integer id);

    // [多个参数]使用自定义参数名
    List<Student> selectMultiParam(@Param("myname") String name, @Param("myage") Integer age);

    // [多个参数]使用java对象的属性值
    List<Student> selectMultiObject(QueryParam param);

    // [多个参数]使用java对象的属性值,形参类型无限制
    List<Student> selectMultiStudent(Student student);

    // [多个参数]使用形参位置
    List<Student> selectMultiPosition(String name, Integer age);

    // [多个参数]使用Map
    List<Student> selectMultiByMap(Map<String, Object> map);

    // 使用$连接符
    List<Student> selectUse$(@Param("myname") String name);

    // 使用 $连接符替换列名
    List<Student> selectUse$Order(@Param("colName") String colName);
}
