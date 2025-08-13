package com.kezhang.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kezhang.common.result.PageResult;
import com.kezhang.common.result.Result;
import com.kezhang.pojo.dto.*;
import com.kezhang.pojo.entity.Employee;
import com.kezhang.service.impl.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;
    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeService){
        this.employeeService = employeeService;
    }
    /*
    * 插入一条员工信息
    * @param employeeInsertDTO 员工信息
    * */
    @PostMapping("/insert")
    public Result<?> insertEmployee(@RequestBody EmployeeInsertDTO employeeInsertDTO) {
        log.info("Request received to insert employee ...");
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeInsertDTO, employee);
        employeeService.save(employee);
        log.info("Employee inserted successfully: {}", employee);
        return Result.success(null);
    }
    /*
    * 插入多条员工信息
    * @param employeeInsertDTOList 员工信息列表
    * 注意：BaseMapper中没有提供批量插入方法，该方法是在IService接口中定义的，
    * */
    @PostMapping("/insert/batch")
    public Result<?> insertEmployees(@RequestBody List<EmployeeInsertDTO> employeeInsertDTOList){
        log.info("Request received to insert multiple employees ...");
        List<Employee> employeeList = employeeInsertDTOList.stream().map(employeeInsertDTO -> {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeInsertDTO, employee);
            return employee;
        }).toList();
        log.info("Converting DTOs to entities completed, total records: {}", employeeList.size());
        employeeService.saveBatch(employeeList);
        log.info("Employees inserted successfully, total records: {}", employeeList.size());
        return Result.success(null);
    }

    /*
    * 删除一条员工信息
    * @param id 员工ID
    * 注意：参数id为Integer类型，但是MyBatis-Plus中的删除方法的参数类型为Long，需要进行一次转换
    * */
    @DeleteMapping("/delete/{id}")
    public Result<?> deleteEmployeeById(@PathVariable("id") Integer id){
        log.info("Request received to delete employee with ID: {}", id);
        employeeService.removeById(id.longValue());
        log.info("Employee with ID: {} deleted successfully.", id);
        return Result.success(null);
    }
    /*
    * 删除多条员工信息
    * @param ids 员工的idList
    * 注意：参数ids为List<Integer>类型，但是MyBatis-Plus中的删除方法的参数类型为Collection<Long>，需要进行一次转换
    * */
    @DeleteMapping("/delete")
    public Result<?> deleteEmployeesByIds(@RequestParam List<Integer> ids){
        log.info("Request received to delete employees with IDs: {}", ids);
        List<Long> idList = ids.stream().map(id -> id.longValue()).toList();
        employeeService.removeByIds(idList);
        log.info("Employees with IDs: {} deleted successfully.", ids);
        return Result.success(null);
    }
    /*
    * 通过Map条件删除
    * @param map 条件Map
    * 注意：MyBatis-Plus中的删除方法的参数类型为Map<String, Object>，需要进行一次转换
    * */
    @DeleteMapping("/delete/conditionMap")
    public Result<?> deleteEmployeeByConditionMap(@RequestBody EmployeeDeleteDTO employeeDeleteDTO) throws IllegalAccessException {
        log.info("Request received to delete employee by condition: {}", employeeDeleteDTO);
        // 将DTO转换为Map
        Map<String, Object> conditionMap = new HashMap<>();
        // 采用反射的方式获取字段名称和值
        Class<?> employeeDeleteDTOClazz = employeeDeleteDTO.getClass();
        Field[] fields = employeeDeleteDTOClazz.getDeclaredFields();
        for (Field field : fields){
            field.setAccessible(true);
            conditionMap.put(field.getName(),field.get(employeeDeleteDTO));
        }
        employeeService.removeByMap(conditionMap);
        log.info("Employee deleted successfully by condition.");
        return Result.success(null);
    }
    /*
    * 通过Wrapper条件删除
    * @param employeeDeleteParam 条件DTO
    * */
    @DeleteMapping("/delete/condition")
    public Result<?> deleteEmployeesByCondition(EmployeeDeleteParam employeeDeleteParam){
        log.info("Request received to delete employees by condition: {}", employeeDeleteParam);
        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();
        // 动态拼接查询条件
        wrapper.like(employeeDeleteParam.getUsername() != null,Employee::getUsername,employeeDeleteParam.getUsername())
                .like(employeeDeleteParam.getName() != null,Employee::getName,employeeDeleteParam.getName());
        employeeService.remove(wrapper);
        log.info("Employees deleted successfully by condition.");
        return Result.success(null);
    }

    /*
    * 更新单个员工信息
    * @param employeeUpdateDTO 员工信息 DTO
    * */
    @PutMapping("/update")
    public Result<?> updateEmployee(@RequestBody EmployeeUpdateDTO employeeUpdateDTO){
        log.info("Request received to update employee: {}", employeeUpdateDTO);
        // 将DTO转换为实体类,并且修改id为Long类型
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeUpdateDTO, employee);
        employee.setId(employeeUpdateDTO.getId().longValue());
        employeeService.updateById(employee);
        log.info("Employee updated successfully.");
        return Result.success(null);
    }
    /*
    * 通过Wrapper条件更新
    * @param employeeConditionalUpdateDTO 员工信息 DTO
    * */
    @PutMapping("/update/condition")
    public Result<?> updateEmployeesByCondition(@RequestBody EmployeeConditionalUpdateDTO employeeConditionalUpdateDTO){
        log.info("Request received to update employees by condition: {}", employeeConditionalUpdateDTO);
        LambdaUpdateWrapper<Employee> wrapper = new LambdaUpdateWrapper<>();
        // 动态拼接查询条件
        wrapper.like(employeeConditionalUpdateDTO.getUsername() != null,Employee::getUsername,employeeConditionalUpdateDTO.getUsername())
                .like(employeeConditionalUpdateDTO.getName() != null,Employee::getName,employeeConditionalUpdateDTO.getName())
                .set(employeeConditionalUpdateDTO.getSalary() != null,Employee::getSalary,employeeConditionalUpdateDTO.getSalary());
        employeeService.update(wrapper);
        log.info("Employees updated successfully by condition.");
        return Result.success(null);
    }

    /**
     * 获取所有员工信息
     * @return 员工列表
     */
    @GetMapping("/select/all")
    public Result<?> getAllEmployees() {
        log.info("Request received ...");
        List<Employee> employeeList = employeeService.list();
        log.info("Fetched all employees successfully. Total records: {}", employeeList.size());
        return Result.success(employeeList);
    }
    /*
    * 查询单个员工信息
    * @param id 员工ID
    * */
    @GetMapping("/select/{id}")
    public Result<?> searchEmployeeById(@PathVariable("id") Integer id){
        log.info("Request received to search employee by ID: {}", id);
        Employee employee = employeeService.getById(id.longValue());
        log.info("Employee with ID: {} found. Details: {}", id, employee);
        return Result.success(employee);
    }
    /*
    * 获取多个员工信息
    * @param ids 员工ID列表
    * */
    @GetMapping("/select")
    public Result<?> searchEmployeesByIds(@RequestParam List<Integer> ids){
        log.info("Request received to search employees by IDs : {}", ids);
        List<Long> idList = ids.stream().map(id -> id.longValue()).toList();
        List<Employee> employees = employeeService.listByIds(idList);
        log.info("Employees with IDs: {} found. Total records: {}", ids, employees.size());
        return Result.success(employees);
    }
    /*
    * 使用QueryWrapper进行条件查询
    * @param employeeQueryParam 查询参数封装
    * */
    @GetMapping("/select/condition")
    public Result<?> searchEmployeesByCondition(EmployeeQueryParam employeeQueryParam){
        log.info("Request received to search employees by condition: {}", employeeQueryParam);
        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();
        // 动态拼接查询条件
        wrapper.eq(employeeQueryParam.getId() != null,Employee::getId,employeeQueryParam.getId())
                .like(employeeQueryParam.getUsername() != null,Employee::getUsername,employeeQueryParam.getUsername())
                .like(employeeQueryParam.getName() != null,Employee::getName,employeeQueryParam.getName())
                .between(employeeQueryParam.getMinSalary() != null && employeeQueryParam.getMaxSalary() != null,Employee::getSalary,employeeQueryParam.getMinSalary(),employeeQueryParam.getMaxSalary())
                .between(employeeQueryParam.getBeginDate() != null && employeeQueryParam.getEndDate() != null,Employee::getEntryDate,employeeQueryParam.getBeginDate(),employeeQueryParam.getEndDate())
                .orderByDesc(Employee::getUpdateTime); // 按照ID降序排序
        // 执行查询
        List<Employee> employeeList = employeeService.list(wrapper);
        log.info("Employees found by condition. Total records: {}", employeeList.size());
        return Result.success(employeeList);
    }
    /*
    * 使用分页插件进行条件分页查询
    * @param employeePageQueryParam 分页查询参数封装
    * */
    @GetMapping("/select/PageCondition")
    public Result<?> searchEmployeesByPageCondition(EmployeePageQueryParam employeePageQueryParam){
        log.info("Request received to search employees by page condition: {}", employeePageQueryParam);
        // 创建分页对象
        Page<Employee> page = new Page<>(employeePageQueryParam.getPage(), employeePageQueryParam.getPageSize());
        // 创建查询条件
        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();
        // 动态拼接查询条件
        wrapper.eq(employeePageQueryParam.getId() != null,Employee::getId,employeePageQueryParam.getId())
                .like(employeePageQueryParam.getUsername() != null,Employee::getUsername,employeePageQueryParam.getUsername())
                .like(employeePageQueryParam.getName() != null,Employee::getName,employeePageQueryParam.getName())
                .between(employeePageQueryParam.getMinSalary() != null && employeePageQueryParam.getMaxSalary() != null,Employee::getSalary,employeePageQueryParam.getMinSalary(),employeePageQueryParam.getMaxSalary())
                .between(employeePageQueryParam.getBeginDate() != null && employeePageQueryParam.getEndDate() != null,Employee::getEntryDate,employeePageQueryParam.getBeginDate(),employeePageQueryParam.getEndDate())
                .orderByDesc(Employee::getUpdateTime); // 按照ID降序排序
        // 执行分页查询
        IPage<Employee> results = employeeService.page(page,wrapper);
        Long total = results.getTotal(); // 获取总记录数
        List<Employee> employeeList = results.getRecords(); // 获取当前页的记录列表
        log.info("Employees found by page condition. Total records: {}, Current page records: {}", total, employeeList.size());
        // 封装并返回
        PageResult<Employee> pageResult = new PageResult<>(total, employeeList);
        return Result.success(pageResult);
    }
}
