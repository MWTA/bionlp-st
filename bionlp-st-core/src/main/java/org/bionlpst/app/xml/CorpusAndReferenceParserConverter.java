package org.bionlpst.app.xml;

import org.bionlpst.corpus.parser.ContentAndReferenceSource;
import org.bionlpst.corpus.parser.bionlpst.BioNLPSTParser;
import org.bionlpst.corpus.parser.bionlpst.InputStreamCollection;
import org.bionlpst.util.dom.DOMElementConverter;
import org.w3c.dom.Element;

public class CorpusAndReferenceParserConverter implements DOMElementConverter<ContentAndReferenceSource> {
	private final CorpusSourceConverter corpusSourceConverter;

	public CorpusAndReferenceParserConverter(ClassLoader classLoader) {
		super();
		this.corpusSourceConverter = new CorpusSourceConverter(classLoader);
	}

	@Override
	public ContentAndReferenceSource convert(Element element) throws Exception {
		InputStreamCollection corpusSource = corpusSourceConverter.convert(element);
		return new BioNLPSTParser(corpusSource);
	}
}
