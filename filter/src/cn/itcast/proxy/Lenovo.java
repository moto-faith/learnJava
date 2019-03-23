package cn.itcast.proxy;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-03-22
 * Time: 14:15
 */
public class Lenovo  implements SaleComputer{

    @Override
    public String sale(double money) {

        return "联想电脑花"+money+"元买了一台...";
    }

    @Override
    public void show() {
        System.out.println("展示电脑....");
    }
}
