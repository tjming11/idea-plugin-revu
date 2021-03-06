package org.sylfra.idea.plugins.revu.externalizing.impl;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import org.sylfra.idea.plugins.revu.model.FileScope;

/**
 * @author <a href="mailto:syllant@gmail.com">Sylvain FRANCOIS</a>
 * @version $Id: FileScopeConverter.java 15 2008-12-14 22:49:21Z syllant $
 */
class FileScopeConverter extends AbstractConverter
{
  public boolean canConvert(Class type)
  {
    return FileScope.class.equals(type);
  }

  public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context)
  {
    FileScope fileScope = (FileScope) source;

    if (fileScope.getPathPattern() != null)
    {
      writer.addAttribute("pathPattern", fileScope.getPathPattern());
    }

    if (fileScope.getVcsAfterRev() != null)
    {
      writer.addAttribute("vcsAfterRev", fileScope.getVcsAfterRev());
    }

    if (fileScope.getVcsBeforeRev() != null)
    {
      writer.addAttribute("vcsBeforeRev", fileScope.getVcsBeforeRev());
    }
  }

  public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context)
  {
    FileScope fileScope = new FileScope();

    fileScope.setPathPattern(reader.getAttribute("pathPattern"));
    fileScope.setVcsAfterRev(reader.getAttribute("vcsAfterRev"));
    fileScope.setVcsBeforeRev(reader.getAttribute("vcsBeforeRev"));

    return fileScope;
  }
}