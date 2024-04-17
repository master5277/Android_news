package com.app.news;

import java.io.Serializable;
import java.util.List;



public class NewsInfo {
    private String reason;
    private ResultBean result;
    private Integer error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public Integer getError_code() {
        return error_code;
    }

    public void setError_code(Integer error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        private String stat;
        private List<DataBean> data;
        private String page;
        private String pageSize;

        public String getStat() {
            return stat;
        }

        public void setStat(String stat) {
            this.stat = stat;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getPageSize() {
            return pageSize;
        }

        public void setPageSize(String pageSize) {
            this.pageSize = pageSize;
        }

        public static class DataBean implements Serializable {
            private String uniquekey;
            private String title;
            private String date;
            private String category;
            private String author_name;
            private String url;
            private String thumbnail_pic_s;
            private String is_content;
            private String thumbnail_pic_s02;
            private String thumbnail_pic_s03;

            public String getUniquekey() {
                return uniquekey;
            }

            public void setUniquekey(String uniquekey) {
                this.uniquekey = uniquekey;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getAuthor_name() {
                return author_name;
            }

            public void setAuthor_name(String author_name) {
                this.author_name = author_name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getThumbnail_pic_s() {
                return thumbnail_pic_s;
            }

            public void setThumbnail_pic_s(String thumbnail_pic_s) {
                this.thumbnail_pic_s = thumbnail_pic_s;
            }

            public String getIs_content() {
                return is_content;
            }

            public void setIs_content(String is_content) {
                this.is_content = is_content;
            }

            public String getThumbnail_pic_s02() {
                return thumbnail_pic_s02;
            }

            public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
                this.thumbnail_pic_s02 = thumbnail_pic_s02;
            }

            public String getThumbnail_pic_s03() {
                return thumbnail_pic_s03;
            }

            public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
                this.thumbnail_pic_s03 = thumbnail_pic_s03;
            }
        }
    }


//
//
//    private String reason;
//
//    private ResultDTO result;
//
//    private Integer errorCode;
//
//    public String getReason() {
//        return reason;
//    }
//
//    public void setReason(String reason) {
//        this.reason = reason;
//    }
//
//    public ResultDTO getResult() {
//        return result;
//    }
//
//    public void setResult(ResultDTO result) {
//        this.result = result;
//    }
//
//    public Integer getErrorCode() {
//        return errorCode;
//    }
//
//    public void setErrorCode(Integer errorCode) {
//        this.errorCode = errorCode;
//    }
//
//    public static class ResultDTO {
//
//        private String stat;
//
//        private List<DataDTO> data;
//
//        private String page;
//
//        private String pageSize;
//
//        public String getStat() {
//            return stat;
//        }
//
//        public void setStat(String stat) {
//            this.stat = stat;
//        }
//
//        public List<DataDTO> getData() {
//            return data;
//        }
//
//        public void setData(List<DataDTO> data) {
//            this.data = data;
//        }
//
//        public String getPage() {
//            return page;
//        }
//
//        public void setPage(String page) {
//            this.page = page;
//        }
//
//        public String getPageSize() {
//            return pageSize;
//        }
//
//        public void setPageSize(String pageSize) {
//            this.pageSize = pageSize;
//        }
//
//        public static class DataDTO {
//
//            private String uniquekey;
//
//            private String title;
//
//            private String date;
//
//            private String category;
//
//            private String authorName;
//
//            private String url;
//
//            private String thumbnailPicS;
//
//            private String thumbnailPicS02;
//
//            private String thumbnailPicS03;
//
//            private String isContent;
//
//            public String getUniquekey() {
//                return uniquekey;
//            }
//
//            public void setUniquekey(String uniquekey) {
//                this.uniquekey = uniquekey;
//            }
//
//            public String getTitle() {
//                return title;
//            }
//
//            public void setTitle(String title) {
//                this.title = title;
//            }
//
//            public String getDate() {
//                return date;
//            }
//
//            public void setDate(String date) {
//                this.date = date;
//            }
//
//            public String getCategory() {
//                return category;
//            }
//
//            public void setCategory(String category) {
//                this.category = category;
//            }
//
//            public String getAuthorName() {
//                return authorName;
//            }
//
//            public void setAuthorName(String authorName) {
//                this.authorName = authorName;
//            }
//
//            public String getUrl() {
//                return url;
//            }
//
//            public void setUrl(String url) {
//                this.url = url;
//            }
//
//            public String getThumbnailPicS() {
//                return thumbnailPicS;
//            }
//
//            public void setThumbnailPicS(String thumbnailPicS) {
//                this.thumbnailPicS = thumbnailPicS;
//            }
//
//            public String getThumbnailPicS02() {
//                return thumbnailPicS02;
//            }
//
//            public void setThumbnailPicS02(String thumbnailPicS02) {
//                this.thumbnailPicS02 = thumbnailPicS02;
//            }
//
//            public String getThumbnailPicS03() {
//                return thumbnailPicS03;
//            }
//
//            public void setThumbnailPicS03(String thumbnailPicS03) {
//                this.thumbnailPicS03 = thumbnailPicS03;
//            }
//
//            public String getIsContent() {
//                return isContent;
//            }
//
//            public void setIsContent(String isContent) {
//                this.isContent = isContent;
//            }
//        }
//    }


}

