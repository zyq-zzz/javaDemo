package jiawo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * <p>
 * ������������ʾ
 * </p>
 */
public class MpGenerator {

    /**
     * <p>
     * MySQL ������ʾ
     * </p>
     */
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
    // ѡ�� freemarker ���棬Ĭ�� Veloctiy
    // mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        // ȫ������
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("E://MPGenerator");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);// ����ҪActiveRecord���Ե����Ϊfalse
        gc.setEnableCache(false);// XML ��������
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
    // .setKotlin(true) �Ƿ����� kotlin ����
        gc.setAuthor("YongQian");

        // �Զ����ļ�������ע�� %s ���Զ�����ʵ�����ԣ�
        // gc.setMapperName("%sDao");
        // gc.setXmlName("%sDao");
        // gc.setServiceName("MP%sService");
        // gc.setServiceImplName("%sServiceDiy");
        // gc.setControllerName("%sAction");
        mpg.setGlobalConfig(gc);

        // ����Դ����
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert(){
            // �Զ������ݿ���ֶ�����ת������ѡ��
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                System.out.println("ת�����ͣ�" + fieldType);
        // ע�⣡��processTypeConvert ����Ĭ������ת�������������Ҫ��Ч�����Զ��巵�ء�������ֱ�ӷ��ء�
                return super.processTypeConvert(fieldType);
            }
        });
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/springboot_jiawo?characterEncoding=utf8");
        mpg.setDataSource(dsc);

        // ��������
        StrategyConfig strategy = new StrategyConfig();
    // strategy.setCapitalMode(true);// ȫ�ִ�д���� ORACLE ע��
//        strategy.setTablePrefix(new String[] { "tlog_", "tsys_" });// �˴������޸�Ϊ���ı�ǰ׺
        strategy.setNaming(NamingStrategy.underline_to_camel);// �������ɲ���
         strategy.setInclude(new String[] { "user","role","permission" }); // ��Ҫ���ɵı�
         strategy.setRestControllerStyle(true);
        // strategy.setExclude(new String[]{"test"}); // �ų����ɵı�
        // �Զ���ʵ�常��
        // strategy.setSuperEntityClass("com.baomidou.demo.TestEntity");
        // �Զ���ʵ�壬�����ֶ�
        // strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
        // �Զ��� mapper ����
        // strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
        // �Զ��� service ����
        // strategy.setSuperServiceClass("com.baomidou.demo.TestService");
        // �Զ��� service ʵ���ุ��
        // strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
        // �Զ��� controller ����
        // strategy.setSuperControllerClass("com.baomidou.demo.TestController");
        // ��ʵ�塿�Ƿ������ֶγ�����Ĭ�� false��
        // public static final String ID = "test_id";
         strategy.setEntityColumnConstant(true);
        // ��ʵ�塿�Ƿ�Ϊ������ģ�ͣ�Ĭ�� false��
        // public User setName(String name) {this.name = name; return this;}
        // strategy.setEntityBuilderModel(true);
        mpg.setStrategy(strategy);

        // ������
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.baomidou");
        pc.setModuleName("test");
        mpg.setPackageInfo(pc);

        // ע���Զ������ã������� VM ��ʹ�� cfg.abc �����ޡ�
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };

        // �Զ��� xxList.jsp ����
//        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
//        focList.add(new FileOutConfig("/template/list.jsp.vm") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // �Զ��������ļ�����
//                return "D://my_" + tableInfo.getEntityName() + ".jsp";
//            }
//        });
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);
//
//    // ���� xml ����Ŀ¼��ʾ
//         focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                return "/develop/code/xml/" + tableInfo.getEntityName() + ".xml";
//            }
//        });
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);

        // �ر�Ĭ�� xml ���ɣ��������� �� ��Ŀ¼
        TemplateConfig tc = new TemplateConfig();
        tc.setXml(null);
        mpg.setTemplate(tc);

        // �Զ���ģ�����ã����� copy Դ�� mybatis-plus/src/main/resources/templates ���������޸ģ�
        // �����Լ���Ŀ�� src/main/resources/templates Ŀ¼��, Ĭ������һ�¿��Բ����ã�Ҳ�����Զ���ģ������
        // TemplateConfig tc = new TemplateConfig();
        // tc.setController("...");
        // tc.setEntity("...");
        // tc.setMapper("...");
        // tc.setXml("...");
        // tc.setService("...");
        // tc.setServiceImpl("...");
    // �����κ�һ��ģ��������� �� OR Null �������ɸ�ģ�顣
        // mpg.setTemplate(tc);

        // ִ������
        mpg.execute();

        // ��ӡע�����á����ޡ�
//        System.err.println(mpg.getCfg().getMap().get("abc"));
    }

}