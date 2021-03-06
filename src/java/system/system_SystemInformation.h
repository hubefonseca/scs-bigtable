/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class system_SystemInformation */

#ifndef _Included_system_SystemInformation
#define _Included_system_SystemInformation
#ifdef __cplusplus
extern "C" {
#endif
#undef system_SystemInformation_MIN_ELAPSED_TIME
#define system_SystemInformation_MIN_ELAPSED_TIME 100L
/*
 * Class:     system_SystemInformation
 * Method:    getProcessID
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_system_SystemInformation_getProcessID
  (JNIEnv *, jclass);

/*
 * Class:     system_SystemInformation
 * Method:    getCPUs
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_system_SystemInformation_getCPUs
  (JNIEnv *, jclass);

/*
 * Class:     system_SystemInformation
 * Method:    getProcessCPUTime
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_system_SystemInformation_getProcessCPUTime
  (JNIEnv *, jclass);

/*
 * Class:     system_SystemInformation
 * Method:    getProcessCPUPercentage
 * Signature: ()D
 */
JNIEXPORT jdouble JNICALL Java_system_SystemInformation_getProcessCPUPercentage
  (JNIEnv *, jclass);

/*
 * Class:     system_SystemInformation
 * Method:    getMaxMem
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_system_SystemInformation_getMaxMem
  (JNIEnv *, jclass);

/*
 * Class:     system_SystemInformation
 * Method:    getFreeMem
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_system_SystemInformation_getFreeMem
  (JNIEnv *, jclass);

/*
 * Class:     system_SystemInformation
 * Method:    getSysInfo
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_system_SystemInformation_getSysInfo
  (JNIEnv *, jclass);

/*
 * Class:     system_SystemInformation
 * Method:    getProcessCPUUsage
 * Signature: ()D
 */
JNIEXPORT jdouble JNICALL Java_system_SystemInformation_getProcessCPUUsage
  (JNIEnv *, jclass);

/*
 * Class:     system_SystemInformation
 * Method:    getMemoryUsage
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_system_SystemInformation_getMemoryUsage
  (JNIEnv *, jclass);

/*
 * Class:     system_SystemInformation
 * Method:    getMemoryResident
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_system_SystemInformation_getMemoryResident
  (JNIEnv *, jclass);

/*
 * Class:     system_SystemInformation
 * Method:    setPid
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_system_SystemInformation_setPid
  (JNIEnv *, jclass, jint);

/*
 * Class:     system_SystemInformation
 * Method:    detachProcess
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_system_SystemInformation_detachProcess
  (JNIEnv *, jclass);

/*
 * Class:     system_SystemInformation
 * Method:    getNativeIOUsage
 * Signature: ()[J
 */
JNIEXPORT jlongArray JNICALL Java_system_SystemInformation_getNativeIOUsage
  (JNIEnv *, jclass);

/*
 * Class:     system_SystemInformation
 * Method:    getNativeNetworkUsage
 * Signature: ()[J
 */
JNIEXPORT jlongArray JNICALL Java_system_SystemInformation_getNativeNetworkUsage
  (JNIEnv *, jclass);

#ifdef __cplusplus
}
#endif
#endif
