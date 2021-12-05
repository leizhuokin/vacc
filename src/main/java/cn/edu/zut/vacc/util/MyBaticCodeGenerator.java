package cn.edu.zut.vacc.util;



import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.SQLException;
import java.util.Collections;

public class MyBaticCodeGenerator {
    //设置是否启用对所有表生成相应的实体类，默认启用
    private static boolean override = false;
    private static String url = "jdbc:mysql://localhost:3306/vacc?useSSL=false";
    private static String username = "root";
    private static String password = "123456";
    private static String parentPackage = "cn.edu.zut.vacc";
    //自动生成代码的开发者的名字，默认为当前登录用户的用户名
    private static String author = "";
    private static String moduleName = "";
    private static String[] tables = {"user","user_vaccine","vaccine"};
    /**
     * 数据源配置
     */
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder(url, username, password);

    /**
     * 执行 run
     */
    public static void main(String[] args) throws SQLException {
        //获取项目目录
        String projectPath = System.getProperty("user.dir");
        //全局配置
        GlobalConfig.Builder globalConfig = new GlobalConfig.Builder()
                .author(author == null ? System.getProperty("user.name") : author) // 设置作者
                //.enableSwagger() // 开启 swagger 模式
                .outputDir(projectPath + "/src/main/java")// 指定输出目录
                .dateType(DateType.TIME_PACK)//时间策略:DateType.ONLY_DATE 默认值: DateType.TIME_PACK
                .commentDate("yyyy-MM-dd");//注释日期:默认值: yyyy-MM-dd
        if(override) globalConfig.fileOverride(); // 覆盖已生成文件
        //包配置
        PackageConfig.Builder packageConfig = new PackageConfig.Builder()
                .parent(parentPackage) // 设置父包名
                .moduleName(moduleName) // 设置父包模块名
                .entity("po")
                .service("service")
                .serviceImpl("service.impl")
                .mapper("mapper")
                .controller("controller")
                .pathInfo(Collections.singletonMap(OutputFile.mapperXml, projectPath+"/src/main/resources/mapper"))
                .other("other");
        //策略配置
        IConfigBuilder<StrategyConfig> strategyConfig = new StrategyConfig.Builder()
                .addInclude(tables)
                .addTablePrefix("sys_")
                .entityBuilder()
                .enableChainModel()
                .enableLombok()
                .enableRemoveIsPrefix()
                .enableTableFieldAnnotation()
                .enableActiveRecord()
                .idType(IdType.AUTO)
                //.versionColumnName("version")
                //.versionPropertyName("version")
                .logicDeleteColumnName("is_deleted")
                //.logicDeletePropertyName("deleted")
                .columnNaming(NamingStrategy.underline_to_camel)
                //.addSuperEntityColumns("id", "created_by", "created_time", "updated_by", "updated_time")
                //.addIgnoreColumns("age")
//                .addTableFills(new Column("create_time", FieldFill.INSERT))
//                .addTableFills(new Property("updateTime", FieldFill.INSERT_UPDATE))
                .mapperBuilder()
                .formatMapperFileName("%sMapper")
                .formatXmlFileName("%sMapper")
                .serviceBuilder()
                .formatServiceFileName("%sService")
                .formatServiceImplFileName("%sServiceImpl")
                .controllerBuilder()
                .formatFileName("%sController")
                .enableRestStyle()
                .enableHyphenStyle()
                ;//.formatFileName("%sEntity");
        // 配置模板
        TemplateConfig.Builder templateConfig = new TemplateConfig.Builder()
                .controller("templates/controller.java")
                .entity("templates/entity.java")
                .service("templates/service.java")
                .serviceImpl("templates/serviceImpl.java")
                .mapper("templates/mapper.java")
                .mapperXml("templates/mapper.xml");
        //开始执行
        new AutoGenerator(DATA_SOURCE_CONFIG.build())
                .global(globalConfig.build())
                .packageInfo(packageConfig.build())
                .template(templateConfig.build())
                .strategy(strategyConfig.build()).execute(new FreemarkerTemplateEngine());

    }
}
