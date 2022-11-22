#include<jni.h>
#include<stdio.h>
#include "TestJNI.h"

JNIEXPORT jint JNICALL Java_TestJNI_add(JNIEnv *env,jobject thisObj,jint n1,jint n2){
	jint resadd;
	resadd = n1 + n2;
	return resadd;
}
JNIEXPORT jint JNICALL Java_TestJNI_sub(JNIEnv *env,jobject thisObj,jint n3,jint n4){
	jint ressub;
	ressub = n3 - n4;
	return ressub;
}
JNIEXPORT jint JNICALL Java_TestJNI_mul(JNIEnv *env,jobject thisObj,jint n5,jint n6){
	jint resmul;
	resmul = n5 * n6;
	return resmul;
}
JNIEXPORT jint JNICALL Java_TestJNI_div(JNIEnv *env,jobject thisObj,jint n7,jint n8){
	jint resdiv;
	resdiv = n7 / n8;
	return resdiv;
}
