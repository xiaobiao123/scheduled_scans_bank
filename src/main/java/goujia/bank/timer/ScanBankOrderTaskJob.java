package goujia.bank.timer;

import goujia.bank.content.GYJBusiness;
import goujia.bank.model.Order;
import goujia.bank.service.OrderService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.goujia.goujiabao.model.GYJQueryOrder;

@Component("scanBankOrderTaskJob")
public class ScanBankOrderTaskJob {
    private static final Logger LOG = LoggerFactory.getLogger(ScanBankOrderTaskJob.class);
    @Autowired
    private OrderService orderService;
    private GYJBusiness gyjBusiness = new GYJBusiness();;

    @Scheduled(cron = "0 */1 * * * ?")
    public void scanBankOrderTask() throws Exception {
        LOG.info("----------------定时扫描银行订单支付状态开始------------------");
        GYJQueryOrder gyjOrder = null;
        // Order order1 = new Order();
        // gyjOrder = gyjBusiness.queryOrder(order1);

        List<Order> listOrder = orderService.listOrder();
        /*
         * for (Order order : listOrder) { try { gyjOrder =
         * gyjBusiness.queryOrder(order); String status = ""; if (gyjOrder !=
         * null && gyjOrder.getOrderstatus().equals("2") &&
         * (order.getStatus().equals("prepaying") ||
         * order.getStatus().equals("accepted_AZZC") ||
         * order.getStatus().equals("paying_AZZC") ||
         * order.getStatus().equals("accepted_JZFZ") || order
         * .getStatus().equals("accepted_YSCS"))) {
         * 
         * if (order.getStatus().endsWith("prepaying")) { status =
         * "arriving_earnest"; } else if
         * (order.getStatus().endsWith("accepted_AZZC")) { status =
         * "arriving_credit"; } else if
         * (order.getStatus().endsWith("paying_AZZC")) { status =
         * "starting_JZFZ"; } else if
         * (order.getStatus().endsWith("accepted_JZFZ")) { status =
         * "starting_YSCS"; } else if
         * (order.getStatus().endsWith("accepted_YSCS")) { status = "completed";
         * } orderService.updateStatus(order.getId(), status); }
         * 
         * } catch (Exception e) {
         * LOG.error("---------定时扫描银行订单支付状态开始:查询订单状态失败------------------");
         * e.printStackTrace();
         * 
         * }
         */
        // }
        System.out.println("任务进行中。。。");
    }
}