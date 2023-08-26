package utils;

public class properties {

    public IConfigService configService;

    public String env;
    public String fileName;
    public String sut_url;

    public String get_url() throws Exception {

        configService = new ConfigFileImpl();

        configService = new ConfigFileImpl();

        if (System.getProperty("env") != null) {
            env = System.getProperty("env");
        } else {
            env = "play";
            fileName = "play";
        }

        configService.load(env, fileName);

        sut_url = configService.getProperty("sut.url");

        return sut_url;
    }
}
