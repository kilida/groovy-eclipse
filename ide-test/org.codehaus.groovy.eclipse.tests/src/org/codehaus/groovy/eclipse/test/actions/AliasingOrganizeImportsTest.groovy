/*
 * Copyright 2003-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.codehaus.groovy.eclipse.test.actions;

/**
 * @author Andrew Eisenberg
 * @created Dec 15, 2010
 */
public class AliasingOrganizeImportsTest extends AbstractOrganizeImportsTest {

	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	
    // should not be removed
    void testSimpleAlias() {
        String contents = 
                """ 
                import other.FirstClass as F${LINE_SEPARATOR}
                
                F
                """
        doAddImportTest(contents)
    }
//    // should be removed
//    void testSimpleAliasRemoval() {
//        String contents = 
//            """ 
//            import other.FirstClass as F
//            
//            def x
//            """
//            doDeleteImportTest(contents, 1)
//    }
//    // should not be removed
//    void testInnerTypeAlias() {
//        String contents = 
//            """ 
//            import other.Outer.Inner as F
//            
//            F
//            """
//            doAddImportTest(contents)
//    }
//    // should be removed
//    void testInnerTypeAliasRemoval() {
//        String contents = 
//            """ 
//            import other.Outer.Inner as F
//            
//            def x
//            """
//            doDeleteImportTest(contents, 1)
//    }
    // should be removed
    // this test really should be moved to OrganizeImportsTest
//    void testInnerTypeRemoval() {
//        String contents = 
//            """ 
//            import other.Outer.Inner as F
//            
//            def x
//            """
//            doDeleteImportTest(contents, 1)
//    }
    // should not be removed
    void testStaticAlias() {
        String contents = 
            """ 
            import static other2.FourthClass.m as j${LINE_SEPARATOR}
            
            j
            """
            doAddImportTest(contents)
    }
    // should not be removed
    void testStaticAlias2() {
        String contents = 
            """ 
            import static other2.FourthClass.m as j${LINE_SEPARATOR}
            
            def x
            """
            doAddImportTest(contents)
    }
    // should not be removed
    void testStaticAliasAnnotation() {
        String contents =
            """
            @Deprecated
            import static other2.FourthClass.m as j
            
            j
            """
            doAddImportTest(contents)
    }
    // should not be removed
    void testAliasAnnotation() {
        String contents =
            """
            @Deprecated
            import static other2.FourthClass as k
            @Deprecated
            import static other2.FourthClass.m as j
            
            j
            """
            doAddImportTest(contents)
    }
    

    // https://issuetracker.springsource.com/browse/STS-3314
    void testMultiAliasing1() {
        String contents =
"""
import other2.FourthClass${LINE_SEPARATOR}
import other3.FourthClass as FourthClass2${LINE_SEPARATOR}
import other4.FourthClass as FourthClass3${LINE_SEPARATOR}

class TypeHelper {
    FourthClass f1
    FourthClass2 f2
    FourthClass3 f3
}
"""
        doAddImportTest(contents)
    }
//    void testMultiAliasing2() {
//        String contents =
//                """
//import other2.FourthClass
//import other3.FourthClass as FourthClass2
//import other4.FourthClass as FourthClass3
//
//class TypeHelper {
//    FourthClass f1
//    FourthClass2 f2
////    FourthClass3 f3
//}
//"""
//                doDeleteImportTest(contents, 1)
//    }
//    
//    // TODO failing on build server...disabled
//    void _testMultiAliasing2a() {
//        String contents =
//                """
//import other3.FourthClass as FourthClass2
//import other4.FourthClass as FourthClass3
//import other2.FourthClass
//
//class TypeHelper {
//    FourthClass f1
//    FourthClass2 f2
////    FourthClass3 f3
//}
//                """
//                doDeleteImportTest(contents, 1)
//    }
//    void testMultiAliasing3() {
//        String contents =
//                """
//import other2.FourthClass
//import other3.FourthClass as FourthClass2
//import other4.FourthClass as FourthClass3
//
//class TypeHelper {
////    FourthClass f1
//    FourthClass2 f2
////    FourthClass3 f3
//}
//                """
//                doDeleteImportTest(contents, 2)
//    }
}
