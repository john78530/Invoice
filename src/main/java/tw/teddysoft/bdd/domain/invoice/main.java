package tw.teddysoft.bdd.domain.invoice;

import tw.teddysoft.bdd.domain.invoice.Invoice;
import tw.teddysoft.bdd.domain.invoice.InvoiceBuilder;

/**
 * Created by joe on 2017/3/29.
 */
public class main {

        public static void main(String[] args) {

            double vatRate = 0.0;
            int taxIncludedPrice = 0;
            int taxExcludedPrice=0;
            InvoiceBuilder invoiceBuilder = InvoiceBuilder.newInstance();

            System.out.println("請數入指令，-i 後面表示 含稅價 -r 表示稅率 -e 表示未稅價 (e.g : -i 100 -r 0.05 -e 101)");

            for (int i = 0 ; i < args.length ; i++)
            {
                switch(args[i]) {
                    case "-i":

                        taxIncludedPrice = Integer.parseInt(args[i+1]);
                        invoiceBuilder = invoiceBuilder.withTaxIncludedPrice(taxIncludedPrice);
                        break;

                    case "-r":

                        vatRate = Double.parseDouble(args[i+1]);
                        invoiceBuilder = invoiceBuilder.withVatRate(vatRate);
                        break;

                    case "-e":

                        taxExcludedPrice = Integer.parseInt(args[i+1]);
                        invoiceBuilder = invoiceBuilder.withTaxExcludedPrice(taxExcludedPrice);
                        break;

                    default:
                        break;
                }
            }

            Invoice invoice = invoiceBuilder.issue();

            System.out.println("含稅價格 = " + invoice.getTaxIncludedPrice());
            System.out.println("未稅價格 = " + invoice.getTaxExcludedPrice());
            System.out.println("稅金 = " + invoice.getVAT());
            System.out.println("稅率 = " + invoice.getVatRate());


        }
}

