package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new com.chat_soon_e.re_chat.DataBinderMapperImpl());
  }
}
