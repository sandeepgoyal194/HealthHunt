package in.healthhunt.presenter.homeScreenPresenter.articlePresenter.myfeedPresenter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import in.healthhunt.model.articles.ArticleParams;
import in.healthhunt.model.articles.articleResponse.Author;
import in.healthhunt.model.articles.articleResponse.CategoriesItem;
import in.healthhunt.model.articles.articleResponse.MediaItem;
import in.healthhunt.model.articles.articleResponse.PostsItem;
import in.healthhunt.model.articles.articleResponse.TagsItem;
import in.healthhunt.model.articles.articleResponse.Title;
import in.healthhunt.view.homeScreenView.article.myfeed.IArticleView;

/**
 * Created by abhishekkumar on 4/27/18.
 */

public class ArticlePresenterImp implements IArticlePresenter {

    private IArticleView IArticleView;
    private Context mContext;
    public ArticlePresenterImp(Context context, IArticleView articleView) {
        mContext = context;
        IArticleView = articleView;
    }


    @Override
    public void loadFragment(String tag, Bundle bundle) {
        IArticleView.showFragment(tag, bundle);
    }

    @Override
    public int getCount() {
        return IArticleView.getArticleCount();
    }

    @Override
    public Fragment getItem(int position, int type) {
        Fragment fragment = IArticleView.getFragmentArticleItem(position);
        Bundle bundle = createBundle(position);
        bundle.putInt(ArticleParams.ARTICLE_TYPE, type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void openViewAll() {

    }

    private Bundle createBundle(int pos) {
        PostsItem postItem = IArticleView.getArticle(pos);

        Bundle bundle = new Bundle();

        if(postItem != null) {

            bundle.putString(ArticleParams.ID, String.valueOf(postItem.getId()));

            String url = null;
            List<MediaItem> mediaItems = postItem.getMedia();
            if(mediaItems != null && !mediaItems.isEmpty()) {
                MediaItem media = mediaItems.get(0);
                Log.i("TAGMedia", "media "+ media);
                if("image".equals(media.getMedia_type())) {
                    url = media.getUrl();
                    Log.i("TAGMedia", "URL "+ url);

                }
            }
            bundle.putString(ArticleParams.ARTICLE_URL, url);

            String categoryName = null;
            List<CategoriesItem> categories = postItem.getCategories();
            if(categories != null && !categories.isEmpty()){
                categoryName = categories.get(0).getName();
            }
            bundle.putString(ArticleParams.CATEGORY_NAME, categoryName);

            Author author = postItem.getAuthor();
            if(author != null){
                bundle.putString(ArticleParams.AUTHOR_NAME, author.getName());
                bundle.putString(ArticleParams.AUTHOR_URL, author.getUrl());

            }

            Title title = postItem.getTitle();
            String articleTitle = null;
            if(title != null) {
                articleTitle = title.getRendered();
            }
            bundle.putString(ArticleParams.ARTICLE_TITLE, articleTitle);


            ArrayList<String> tagsName = null;
            List<TagsItem> tagItems = postItem.getTags();
            if(tagItems != null && !tagItems.isEmpty()) {
                tagsName = new ArrayList<String>();
                for(TagsItem  tagItem: tagItems) {
                    Log.i("TAG11", tagItem.getName());
                    tagsName.add(tagItem.getName());
                }
            }

            bundle.putStringArrayList(ArticleParams.ARTICLE_TAGS_NAME_LIST, tagsName);

            Log.i("TAGRead", "read " + postItem.getRead_time());
            bundle.putString(ArticleParams.ARTICLE_READ_TIME, postItem.getRead_time());

            String date = postItem.getDate();
            /*if(date != null) {
                date = HealthHuntUtility.getDateWithFormat("dd-MMM-yyyy", date);
            }*/
            bundle.putString(ArticleParams.ARTICLE_DATE, date);
        }

        int count = IArticleView.getArticleCount();
        if(pos == count - 1) {
            bundle.putBoolean(ArticleParams.IS_LAST_PAGE, true);
        }
        else {
            bundle.putBoolean(ArticleParams.IS_LAST_PAGE, false);
        }

        return bundle;
    }
}
