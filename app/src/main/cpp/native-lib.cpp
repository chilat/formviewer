#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring

JNICALL
Java_com_erop_formviewer_util_NativeTasks_getUrl(
        JNIEnv *env,
        jobject /* this */) {
    std::string url = "https://api.ona.io/api/v1/";
    return env->NewStringUTF(url.c_str());
}
