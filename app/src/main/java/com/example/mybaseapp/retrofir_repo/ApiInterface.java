package com.example.mybaseapp.retrofir_repo;


import com.example.mybaseapp.data.*;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("registration_post")
    Call<SignUpWrapper> registrationApi(
            @Body SignUpEntity signUpEntity);

    @POST("login")
    Call<SignUpWrapper> loginApi(
            @Body LoginEntity loginEntity);

    @POST("getdata.php")
    Call<GetImageWrapper> getdata(
            @Body GetImageEntity getImageEntity);

//    @POST("forgetPassword")
//    Call<ForgotWrapper> forgetPasswordApi(@Body ForgotEntity entity);
//
//    @POST("validateAnswer")
//    Call<ForgotValidData> validateAnswerApi(@Body ForgotValidEntity forgotValidEntity);
//
//    @POST("changePassword")
//    Call<ForgotValidData> changePasswordApi(
//            @Body ChangePasswordEntity changePasswordEntity);
//
//    @POST("friendRequest")
//    Call<ReportResponce> friendRequestApi(
//            @Body RequestAcceptEntity requestAcceptEntity);
//
//    @POST("followup")
//    Call<PostResponce> followupApi(
//            @Body FollowEntity followupEntity);
//
//    @POST("follwerlist")
//    Call<FollowerWrapper> follwerlistApi(
//            @Body FollowerListEntity followerListEntity);
//
//    @POST("unfollow")
//    Call<PostResponce> unfollowApi(
//            @Body FollowEntity followupEntity);
//
//    @POST("invites")
//    Call<InviteWrapper> invitesApi(
//            @Body InviteEntity inviteEntity);
//
//    @POST("reportSpam")
//    Call<ReportResponce> reportSpamApi(
//            @Body ReportEntity reportEntity);
//
//    @POST("requestApproval")
//    Call<CommonRespose> requestApprovalApi(
//            @Body AcceptEntity acceptEntity);
//
//    @Multipart
//    @POST("updateProfile")
//    Call<SignUpWrapper> updateProfileApi(@Part("user_id") RequestBody user_id,
//                                         @Part("name") RequestBody name,
//                                         @Part("username") RequestBody username,
//                                         @Part("about") RequestBody about,
//                                         @Part("gender") RequestBody gender,
//                                         @Part("phone") RequestBody phone,
//                                         @Part MultipartBody.Part profilePic);
//
//    @Multipart
//    @POST("add_post")
//    Call<PostResponce> addPostApi(@Part("user_id") RequestBody user_id,
//                                  @Part("post") RequestBody post,
//                                  @Part("post_type") RequestBody postType,
//                                  @Part("visibility") RequestBody visibility,
//                                  @Part("post_visible") RequestBody postVisible,
//                                  @Part MultipartBody.Part post_image);
//
//    @Multipart
//    @POST("add_post")
//    Call<PostResponce> addThatPostApi(@Part("user_id") RequestBody user_id,
//                                      @Part("post") RequestBody post,
//                                      @Part("post_type") RequestBody postType,
//                                      @Part("visibility") RequestBody visibility,
//                                      @Part("post_visible") RequestBody post_visible,
//                                      @Part MultipartBody.Part post_image);
//
//    @Multipart
//    @POST("add_post")
//    Call<PostResponce> addImagePostApi(@Part("user_id") RequestBody user_id,
//                                       @Part("post") RequestBody post,
//                                       @Part("post_type") RequestBody postType,
//                                       @Part("visibility") RequestBody visibility,
//                                       @Part("post_visible") RequestBody postVisible,
//                                       @Part("title[]") ArrayList<RequestBody> title,
//                                       @Part ArrayList<MultipartBody.Part> imageParts);
//
//    @POST("getprofile")
//    Call<SignUpWrapper> getProfileApi(@Body ProfileEntity entity);
//
//    @POST("deletePost")
//    Call<PostResponce> deletePostApi(@Body DeletePostEntity deletePostEntity);
//
//    @POST("wardrobe_post")
//    Call<PostResponce> wardrobePostApi(@Body String category_id,
//                                       @Body String post_image);
//
//    @POST("getFriendList")
//    Call<InviteWrapper> getFriendListApi(@Body FriendEntity friendEntity);
//
//    @POST("getcmsPage")
//    Call<PagesWrapper> pagesApi(@Body PageEntity pageEntity);
//
//    @GET("securityQuestion")
//    Call<QuestionWrapper> securityQuestionApi();
//
//    @POST("getPost")
//    Call<PostWrapper> getPostApi(@Body GetPostEntity getPostEntity);
//
//    @Multipart
//    @POST("editpost")
//    Call<PostResponce> editPostApi(@Part("user_id") RequestBody user_id,
//                                   @Part("post_id") RequestBody post_id,
//                                   @Part("post") RequestBody post,
//                                   @Part("post_type") RequestBody postType,
//                                   @Part("access_level") RequestBody access_level,
//                                   @Part("deleted") RequestBody deleted,
//                                   @Part("new_title") RequestBody new_title,
//                                   @Part("post_visible") RequestBody postVisible,
//                                   @Part("title") RequestBody changeTitle,
//                                   @Part("titleid") RequestBody titleid,
//                                   @Part MultipartBody.Part post_image,  //post_image
//                                   @Part ArrayList<MultipartBody.Part> new_image,  //new_image
//                                   @Part ArrayList<MultipartBody.Part> changeimage);  //changeimage
//
//    @POST("getUserlist")
//    Call<UserWrapper> getUserlistApi(@Body GetPostEntity getPostEntity);
//
//    @POST("friendRequest")
//    Call<PostResponce> friendRequestApi(@Body UserEntity userEntity);
//
//    @POST("requestApproval")
//    Call<PostResponce> requestApprovalApi(@Body UserEntity userEntity);
//
//    @POST("addLike")
//    Call<PostResponce> addLikeApi(@Body LikeEntity likeEntity);
//
//    @POST("postcomment")
//    Call<PostResponce> postCommentApi(@Body PostCommentEntity postCommentEntity);
//
//    @POST("getreadcomment")
//    Call<CommentWrapper> getReadCommentApi(@Body GetCommentEntity getCommentEntity);
//
//    @POST("blockUsrList")
//    Call<BlockWrapper> blockUsrListApi(@Body GetPostEntity getPostEntity);
//
//    @POST("sharedPost")
//    Call<PostResponce> sharedPostApi(@Body SharePostEntity sharePostEntity);
//
//    @POST("upvotes")
//    Call<PostResponce> upvotesApi(@Body UpvoteEntity upvoteEntity);
//
//    @POST("getNotificatioList")
//    Call<NotificationWrapper> getNotificationListApi(@Body GetPostEntity getPostEntity);
//
//    @POST("getWardrobeList")
//    Call<WardrobeWrapper> getWardrobeListApi(@Body GetPostEntity getPostEntity);
//
//    @POST("getWardrobePostList")
//    Call<WardCategoryWrapper> getWardrobePostListApi(@Body WardrobePostListEntity wardrobePostListEntity);
//
//    @POST("createwardrobe")
//    Call<PostResponce> createwardrobeApi(@Body CreateWardrobeEntity createWardrobeEntity);
//
//    @Multipart
//    @POST("wardrobe_post")
//    Call<PostResponce> wardrobe_postApi(@Part("category_id") RequestBody category_id,
//                                        @Part ArrayList<MultipartBody.Part> post_image);  // post_image
//
//    @POST("badgesList")
//    Call<BadgesWrapper> badgesListApi(@Body GetPostEntity getPostEntity);
//
//    @POST("claimBadges")
//    Call<PostResponce> claimBadgesApi(@Body BadgeClaimEntity badgeClaimEntity);
//
//    @POST("useAuth")
//    Call<PostResponce> useAuthApi(@Body GetPostEntity getPostEntity);
//
//    @POST("settingStatus")
//    Call<PostResponce> settingStatusApi(@Body GetPostEntity getPostEntity);
//
//    @POST("updateQuickBlox")
//    Call<PostResponce> updateQuickBloxApi(@Body QuickBloxEntity quickBloxEntity);


}