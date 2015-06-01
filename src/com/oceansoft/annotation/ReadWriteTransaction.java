/**
* <p>
* @Title: ReadWriteTransaction.java
* <p>
* @Package com.oceansoft.annotation
* <p>
* @author zjw
* <p>
* @version V1.0
* <p>
* @date   2015-3-28 обнГ1:17:41
* <p>
*/
package com.oceansoft.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: TODO
 *
 * @author zjw
 * 
 *      @create time  2015-3-28 обнГ1:17:41
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Transactional(value = "readWriteTransaction", propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public @interface ReadWriteTransaction {

}
