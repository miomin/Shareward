package scu.miomin.com.shareward.activity.rxjavamvp.retrofit.module;

import java.util.List;

/**
 * Created by miomin on 16/11/13.
 */

public class DBMovieEntity {

    @Override
    public String toString() {
        return "DBMovieEntity{" +
                "alt='" + alt + '\'' +
                ", rating=" + rating +
                ", title='" + title + '\'' +
                ", collect_count=" + collect_count +
                ", original_title='" + original_title + '\'' +
                ", subtype='" + subtype + '\'' +
                ", year='" + year + '\'' +
                ", images=" + images +
                ", id='" + id + '\'' +
                ", genres=" + genres +
                ", casts=" + casts +
                ", directors=" + directors +
                '}';
    }

    private RatingBean rating;
    private String title;
    private int collect_count;
    private String original_title;
    private String subtype;
    private String year;
    private ImagesBean images;
    private String alt;
    private String id;
    private List<String> genres;
    private List<CastsBean> casts;
    private List<DirectorsBean> directors;


    public static class RatingBean {

        @Override
        public String toString() {
            return "RatingBean{" +
                    "average=" + average +
                    ", max=" + max +
                    ", stars='" + stars + '\'' +
                    ", min=" + min +
                    '}';
        }

        private int max;
        private double average;
        private String stars;
        private int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public double getAverage() {
            return average;
        }

        public void setAverage(double average) {
            this.average = average;
        }

        public String getStars() {
            return stars;
        }

        public void setStars(String stars) {
            this.stars = stars;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }

    public static class ImagesBean {

        @Override
        public String toString() {
            return "ImagesBean{" +
                    "large='" + large + '\'' +
                    ", small='" + small + '\'' +
                    ", medium='" + medium + '\'' +
                    '}';
        }

        private String small;
        private String large;
        private String medium;
    }

    public static class CastsBean {

        @Override
        public String toString() {
            return "CastsBean{" +
                    "alt='" + alt + '\'' +
                    ", avatars=" + avatars +
                    ", name='" + name + '\'' +
                    ", id='" + id + '\'' +
                    '}';
        }

        private String alt;
        private AvatarsBean avatars;
        private String name;
        private String id;

        public static class AvatarsBean {

            @Override
            public String toString() {
                return "AvatarsBean{" +
                        "large='" + large + '\'' +
                        ", small='" + small + '\'' +
                        ", medium='" + medium + '\'' +
                        '}';
            }

            private String small;
            private String large;
            private String medium;
        }
    }

    public static class DirectorsBean {

        @Override
        public String toString() {
            return "DirectorsBean{" +
                    "alt='" + alt + '\'' +
                    ", avatars=" + avatars +
                    ", name='" + name + '\'' +
                    ", id='" + id + '\'' +
                    '}';
        }

        private String alt;
        private AvatarsBean avatars;
        private String name;
        private String id;

        public static class AvatarsBean {

            @Override
            public String toString() {
                return "AvatarsBean{" +
                        "large='" + large + '\'' +
                        ", small='" + small + '\'' +
                        ", medium='" + medium + '\'' +
                        '}';
            }

            private String small;
            private String large;
            private String medium;
        }
    }
}
