package algorithm.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @description: 0-1 背包
 * 有 n 件物品和一个最大承重为 W 的背包，每件物品的重量是 𝑤i、价值是 𝑣i ，在保证总重量不超过 W 的前提下，将哪几件物品装入背包，可以使得背包的总价值最大？
 * 注意：每个物品只有 1 件，也就是每个物品只能选择 0 件或者 1 件，因此称为 0-1背包问题
 * 如果采取贪心策略，有3个方案
 * ① 价值主导：优先选择价值最高的物品放进背包
 * ② 重量主导：优先选择重量最轻的物品放进背包
 * ③ 价值密度主导：优先选择价值密度最高的物品放进背包（价值密度 = 价值 / 重量）
 * @author: FuBiaoLiu
 * @date: 2020/2/4
 */
public class Knapsack {
    public double pack(String title, Comparator<Article> cmp) {
        Article[] articles = new Article[]{
                new Article(35, 10), new Article(30, 40),
                new Article(60, 30), new Article(50, 50),
                new Article(40, 35), new Article(10, 40),
                new Article(25, 30)
        };

        Arrays.sort(articles, cmp);
        double totalPrice = 0;
        int weight = 150;
        List<Article> selected = new ArrayList<>();

        for (Article article : articles) {
            if (weight > 0 && weight >= article.getWeight()) {
                weight -= article.getWeight();
                totalPrice += article.getPrice();
                selected.add(article);
            }
        }

        show(title, totalPrice, selected);
        return totalPrice;
    }

    private void show(String title, double totalPrice, List<Article> selected) {
        System.out.println("【" + title + "】");
        System.out.println("总价值：" + totalPrice);
        for (Article article : selected) {
            System.out.println(article);
        }
        System.out.println("-----------------------------");
    }
}
